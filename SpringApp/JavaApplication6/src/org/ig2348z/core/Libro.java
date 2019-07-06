/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ig2348z.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//@Scope("prototype")

public class Libro implements Item{
    
//    @Autowired
//    @Qualifier("autor2")
    private Autores autores;
    @Value("${email}")
    private String email;
    @Value("${companyName}")
    private String nameCompany;

    
    public Libro(Autores autores) {
        this.autores = autores;
    }

    public String getEmail() {
        return email;
    }

    public String getNameCompany() {
        return nameCompany;
    }
    

    public String getInfoAutores() {
        return autores.sideInfo();
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public Autores getAutores() {
        return autores;
    }

    @Override
    public String doSomething() {
        return "holi jeje";
    }

  
}
