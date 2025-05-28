/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MercadoLivreWrapperDTO {
    
    private int code;
    private MercadoLivreProdutoDTO body;
    
    public int getCode(){ return code;}
    public void setCode(int code){this.code=code;}
    
    public MercadoLivreProdutoDTO getBody() {return body;}
    public void setBody(MercadoLivreProdutoDTO body) {this.body=body;}
       
    
}
