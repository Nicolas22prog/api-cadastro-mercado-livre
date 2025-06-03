/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MercadoLivreService {
    //url da api do mercado livre que retorna os produtos
    private static final String URL_BASE = "https://api.mercadolibre.com/items?ids=";
    
    private Client client = ClientBuilder.newClient();
    private ObjectMapper mapper = new ObjectMapper();
    
    public List<Produto> importarProduto(String ids) {
        //adiciona o token para autenticação do usuario
        String token = "APP_USR-8021611602487823-060307-662d87ba6d0fc8f86e5023a5667e85c1-445066511";
        
        //concatenacao da url com os IDs dos produtos escolhidos para o cadastro, MAXIMO 20 itens por request
        WebTarget target = client.target(URL_BASE + ids);
        
       // adiciona o token na requisicao
        Response response = target
        .request(MediaType.APPLICATION_JSON)
        .header("Authorization", "Bearer " + token)
        .get();
        
        if(response.getStatus()!= 200) {
            throw new RuntimeException("Erro ao buscar produto Mercado Livre, status: " + response.getStatus());
        }
        
        // ler a entidade que recebe do servidor e armazena em "json"
        String json = response.readEntity(String.class);
        
        //transforma em uma lista 
        try {
            List<MercadoLivreWrapperDTO> dtos = mapper.readValue(json, new TypeReference<List<MercadoLivreWrapperDTO>>(){}
            );
            
            List<Produto> produtos = new ArrayList<>();
            for(MercadoLivreWrapperDTO wrapper: dtos) {
                
            Produto produto = converterParaProduto(wrapper.getBody());
            produtos.add(produto);
                
            }
            return  produtos;
            
            
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler JSON do produto", e);
        }
        
        
        
    }
    
 
        // transforma o json em um objeto produto
        private Produto converterParaProduto(MercadoLivreProdutoDTO dto) {
            Produto p = new Produto();
            p.setId(dto.getId());
            p.setTitle(dto.getTitle());
            p.setSellerId(dto.getSeller_id());
            p.setIdCategoria(dto.getCategory_id());
            p.setPrice(dto.getPrice());
            p.setQnt(dto.getAvailable_quantity());
            p.setGarantia(verificarGarantia(dto));
            p.setPermalink(dto.getPermalink());
            p.setThumbnail(dto.getThumbnail());
            p.setShippingMode(dto.getShipping().getMode());
            p.setLogisticType(dto.getShipping().getLogistic_type());
            p.setStatus(dto.getStatus());
            p.setDate_created(dto.getDate_created());
            
            boolean temGarantia = verificarGarantia(dto);
            p.setGarantia(temGarantia);
            if(temGarantia){
                Garantia g = new Garantia();
                g.setId ("Garantia_"+p.getId());
                g.setDuracaoMeses(extrairDuracaoMeses(dto));
                g.setOrigem(extrairOrigemGarantia(dto));
                p.setDadosGarantia(g);
            }
            return p;
        }
        
        //verifica se existe garantia no produto, caso nao exista ele registra como undefined e nao cadastra os atributos de origem e duracao
        private boolean verificarGarantia(MercadoLivreProdutoDTO dto) {
            if (dto.getSale_terms() == null) return false;
            return dto.getSale_terms().stream()
                    .anyMatch(term->"WARRANTY_TIME".equals(term.getId()) && term.getValue_struct() != null);
        }
        
        private String extrairOrigemGarantia(MercadoLivreProdutoDTO dto) {
            if (dto.getSale_terms() == null) return "Não Informada";
            return dto.getSale_terms().stream()
                .filter(term -> "WARRANTY_TYPE".equals(term.getId()))
                .findFirst()
                .map(term -> term.getValue_name())
                .orElse("Não Informada");
        }
        
        private Integer extrairDuracaoMeses(MercadoLivreProdutoDTO dto) {
            
            return dto.getSale_terms().stream()
                .filter(term -> "WARRANTY_TIME".equals(term.getId()))
                .map(SaleTerm::getValue_struct)
                .filter(vs -> vs != null && vs.getNumber() != null)
                .map(ValueStruct::getNumber)
                .findFirst()
                .orElse(0);
}
}
