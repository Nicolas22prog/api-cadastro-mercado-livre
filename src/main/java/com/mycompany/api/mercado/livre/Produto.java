/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table( name = "produtos")
public class Produto implements Serializable{
    
    
    @Id
    
    private String id;
    private String title;
    int seller_id;
    private String category_id;
    private BigDecimal price;
    int available_quantity;    
    private boolean garantia;
    private String permalink;
    private String thumbnail;
    private String shippingMode;
    private String logisticType;
    private String status;
    private LocalDate dataCreated;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "garantia_id")
    private Garantia dadosGarantia;
    
    
    // getters e setters
    public String getId (){return id;}
    public void setId(String id) {this.id=id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title=title;}
    public int getSellerId(){return seller_id;}
    public void setSellerId(int seller_id) {this.seller_id=seller_id;}
    public String getIdCategoria(){return category_id;}
    public void setIdCategoria(String category_id) {this.category_id=category_id;}
    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price=price;}
    public int getQnt() {return available_quantity;}
    public void setQnt(int available_quantity) {this.available_quantity=available_quantity;}
    public boolean isGarantia() {return garantia;}
    public void setGarantia(boolean garantia) {this.garantia=garantia;}
    public String getPermalink(){return permalink;}
    public void setPermalink(String permalink) {this.permalink=permalink;}
    public String getThumbnail(){return thumbnail;}
    public void setThumbnail(String thumbnail){this.thumbnail=thumbnail;}
    public String getShippingMode(){return shippingMode;}
    public void setShippingMode(String shippingMode) {this.shippingMode=shippingMode;}
    public String getLogisticType(){return logisticType;}
    public void setLogisticType(String logisticType) {this.logisticType=logisticType;}
    public String getStatus(){return status;}
    public void setStatus(String status) {this.status=status;}
    public LocalDate getDataCreated() {return dataCreated;}
    public void setDataCreated(LocalDate dataCreated) {this.dataCreated=dataCreated;}
    public Garantia getDadosGarantia(){return dadosGarantia;}
    public void setDadosGarantia(Garantia dadosGarantia) {this.dadosGarantia=dadosGarantia;}
}
