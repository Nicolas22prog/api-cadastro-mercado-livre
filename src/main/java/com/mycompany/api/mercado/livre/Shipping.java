/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.mercado.livre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author nicol
 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public  class Shipping{
         private String mode;
    private String logistic_type;
    

    // Getters e setters
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLogistic_type() {
        return logistic_type;
    }

    public void setLogistic_type(String logistic_type) {
        this.logistic_type = logistic_type;
    }

  
    }