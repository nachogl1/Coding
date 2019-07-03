package IoC;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class JefeEmpleado implements Empleado {

    @Override
    public String getTasks() {
        return "Hi pal, I am one of the bosses";
    }

    @Override
    public String getInforme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
