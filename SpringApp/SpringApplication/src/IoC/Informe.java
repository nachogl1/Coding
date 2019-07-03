package IoC;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class Informe implements CreacionInformes {

    @Override
    public String getInforme() {
     return "This is the presentation of the report";
    }
    
}
