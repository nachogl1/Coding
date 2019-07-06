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
    
    public void init(){
        System.out.println("This is the part of the code where you can connect to a db or "
                + "whatever before starting the bean");
    }
    
    public void destroy(){
        System.out.println("This is where you can allocate code to do before te bean destruction like closing resources");
    }

}
