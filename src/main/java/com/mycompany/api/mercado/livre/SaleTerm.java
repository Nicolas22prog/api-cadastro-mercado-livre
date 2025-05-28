/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class SaleTerm {
         private String id;
            private String name;
            private String value_name;
            private ValueStruct value_struct;

            public String getId(){return id;}
            public void setId(String id) {this.id=id;}
            public String getName(){return name;}
            public void setName(String name) {this.name=name;}
            public String getValue_name(){return value_name;}
            public void setValue_name(String value_name) {this.value_name=value_name;}
            public ValueStruct getValue_struct(){return value_struct;}
            public void setValue_Struct(ValueStruct value_struct) {this.value_struct=value_struct;}

}
