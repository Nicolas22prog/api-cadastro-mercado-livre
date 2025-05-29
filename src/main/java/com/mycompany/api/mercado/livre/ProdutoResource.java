/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;


import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;


import java.util.List;
import java.util.stream.Collectors;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private MercadoLivreService mls;
    
    
    @GET
    @Transactional
    public List<Produto> listar(){
         return em.createQuery("SELECT p FROM Produto p",Produto.class ).getResultList();
    }
    
    @GET
    @Path("/importar")
    @Transactional
    public Response importarVarios(@QueryParam("ids")String idsParam) {
        //Converte a string de entrada para uma lista de IDs(strings)
    List<String> idsRecebidos = Arrays.stream(idsParam.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    
    //Buscar por IDs que já existam no banco
    
    List<String> idsExistentes = em.createQuery(
            "SELECT p.id FROM Produto p WHERE p.id IN :ids", String.class)
            .setParameter("ids", idsRecebidos)
            .getResultList();
    
    //Filtrar os que ainda nao existem no banco
    
    List<String> idsParaImportar = idsRecebidos.stream()
            .filter(id-> !idsExistentes.contains(id))
            .collect(Collectors.toList());
    
    
    //IMporta os produtos restantes
    
    List<Produto> produtosImportados= new ArrayList<>();
    for (String id : idsParaImportar) {
        List<Produto> produtos = mls.importarProduto(id);
        for(Produto p: produtos) {
            em.persist(p);
            produtosImportados.add(p);
        }
    }
    
    return Response.status(Response.Status.CREATED)
            .entity(produtosImportados)
            .build();
}
}
