/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ig2348z.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);
        Libro libro =  factory.getBean("getOneLibro", Libro.class);
        
        System.out.println(libro.doSomething());
        System.out.println(libro.getEmail());
        factory.close();

    }
}
