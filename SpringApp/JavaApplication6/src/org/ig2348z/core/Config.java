/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ig2348z.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Ignacio_Gonzalez
 */
@Configuration
@ComponentScan("org.ig2348z.core")
@PropertySource("classpath:company.properties")
public class Config {
    
    @Bean
    public Autores getOneAutor(){
        return new Autor();
    } 
    @Bean
    public Libro getOneLibro(){
        return new Libro(getOneAutor());
    }
    
    
    
    
}
