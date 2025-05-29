/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public  class ValueStruct{
        private Integer number;
        private String unit;
        
        public Integer getNumber(){return number;}
        public void setNumber(Integer number) {this.number=number;}
        
        public String getUnit() {return unit;}
        public void setUnit(String unit) {this.unit=unit;}
    
}

