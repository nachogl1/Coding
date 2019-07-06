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
          SecretarioEmpleado juan = context.getBean("secretaryBean",SecretarioEmpleado.class);
          System.out.println(juan.getTasks());
          System.out.println(juan.getInforme());
          System.out.println(juan.getEmail());
          context.close();
    }
}
