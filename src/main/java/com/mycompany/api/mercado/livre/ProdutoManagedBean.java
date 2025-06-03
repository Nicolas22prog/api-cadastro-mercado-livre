/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;


import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProdutoManagedBean implements Serializable{
    
    @Inject
    private ProdutoBean pb;
    
    private Produto produto = new Produto();
    
    public Produto getProduct() {
        return produto;
    }

    public void setProduct(Produto produto) {
        this.produto = produto;
    }
    
    
    public List<Produto> listar() {
        return pb.getProdutos();
    }
    
    public List<Garantia> listarGarantia(){
        return pb.getGarantias();
    }
}
