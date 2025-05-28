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


import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private MercadoLivreService mls;
    
    @GET
    @Path("/importar")
    @Transactional
    public Response importarVarios(@QueryParam("ids")String idsParam) {
        List<String> ids = List.of(idsParam.split(","));
        List<Produto> produtos = mls.importarProdutos(ids);
        for (Produto p : produtos) {
            em.persist(p);
        }
        return Response.status(Response.Status.CREATED).entity(produtos).build();
    }

}
