/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProdutoBean {
    
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Produto> getProdutos() {
        return em.createQuery("SELECT p FROM Produto p",Produto.class ).getResultList();
    }
}
