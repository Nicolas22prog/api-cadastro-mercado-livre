/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MercadoLivreProdutoDTO {
    private String id;
    
    private String title;
    private int seller_id;
    private String category_id;
    private BigDecimal price;
    private int available_quantity;
    private String permalink;
    private String thumbnail;
    private Shipping shipping;
    private String status;
    private List<SaleTerm> sale_terms;
    
    
    
    public String getId(){return id;}
    public void setId(String id) {this.id=id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title=title;}
    public int getSeller_id(){return seller_id;}
    public void setSeller_id(int seller_id) {this.seller_id=seller_id;}
    public String getCategory_id() {return category_id;}
    public void setCategory_id(String category_id) {this.category_id=category_id;}
    public BigDecimal getPrice () {return price;}
    public void setPrice(BigDecimal price) {this.price=price;}
    public int getAvailable_quantity() {return available_quantity;}
    public void setAvailable_quantity(int available_quantity) {this.available_quantity=available_quantity;}
    public String getPermalink(){return permalink;}
    public void setPermalink(String permalink) {this.permalink=permalink;}
    public String getThumbnail(){return thumbnail;}
    public void setThumbnail(String thumbnail){this.thumbnail=thumbnail;}
    public Shipping getShipping(){return shipping;}
    public void setShipping(Shipping shipping) {this.shipping=shipping;}
    public String getStatus(){return status;}
    public void setStatus(String status) {this.status=status;}
    public List<SaleTerm> getSale_terms(){return sale_terms;}
    public void setSale_terms(List<SaleTerm> sale_terms) {this.sale_terms=sale_terms;}   
}
