package IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class UsoEmpleados {

    public static void main(String[] args) {
        
//        Empleado empleado1 = new DirectorEmpleado();
//        System.out.println(empleado1.getTasks());
          ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
          Empleado juan = context.getBean("miSecretarioEmpleado",Empleado.class);
          System.out.println(juan.getTasks());
          System.out.println(juan.getInforme());
          context.close();
    }
}
