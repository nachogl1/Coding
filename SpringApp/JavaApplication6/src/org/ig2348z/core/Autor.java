package org.ig2348z.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.stereotype.Component;


public class Autor implements Autores {

    @Override
    public String sideInfo() {
        return "Eyou papa";
    }
}
