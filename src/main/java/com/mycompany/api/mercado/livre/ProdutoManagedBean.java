/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;

import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ProdutoManagedBean implements Serializable{
    
    @EJB
    private ProdutoBean produtoBean;
    
    private Produto produto = new Produto();
    
    public Produto getProduct() {
        return produto;
    }

    public void setProduct(Produto produto) {
        this.produto = produto;
    }
    
    
    public void listar() {
        produtoBean.getProdutos();
    }
}
