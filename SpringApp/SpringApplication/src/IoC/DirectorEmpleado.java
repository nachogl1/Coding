/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoC;

/**
 *
 * @author Ignacio_Gonzalez
 */
class DirectorEmpleado implements Empleado {

    private CreacionInformes informeNuevo;
    
    public DirectorEmpleado(CreacionInformes informeNew){
    this.informeNuevo=informeNew;
    }
    
    @Override
    public String getTasks() {
        return "I am a director";
    }

    @Override
    public String getInforme() {
     return "Informe de Director: " + informeNuevo.getInforme();
    }

}
