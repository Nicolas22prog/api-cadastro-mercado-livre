/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "garantias")
public class Garantia {
    @Id
    
    private String id;
    private Integer duracaoMeses;
    private String origem;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id=id;
    }
    
    public Integer getDuracaoMeses() {
        return duracaoMeses;
    }
    public void setDuracaoMeses(Integer duracaoMeses) {
        this.duracaoMeses=duracaoMeses;
    }
    
    public String getOrigem() {
        return origem;
    }
    
    public void setOrigem(String origem) {
        this.origem=origem;
    }
}
