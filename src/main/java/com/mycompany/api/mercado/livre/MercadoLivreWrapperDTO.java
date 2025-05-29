
package com.mycompany.api.mercado.livre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MercadoLivreWrapperDTO {
    
    private int code;
    private MercadoLivreProdutoDTO body;
    
    //getter e setter para transformar em lista
    public int getCode(){ return code;}
    public void setCode(int code){this.code=code;}
    
    public MercadoLivreProdutoDTO getBody() {return body;}
    public void setBody(MercadoLivreProdutoDTO body) {this.body=body;}
       
    
}
