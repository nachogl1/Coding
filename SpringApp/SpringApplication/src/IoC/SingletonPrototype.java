package IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class SingletonPrototype {
    public static void main(String[] args) {
        
//        Empleado empleado1 = new DirectorEmpleado();
//        System.out.println(empleado1.getTasks());
          ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
          SecretarioEmpleado juan = context.getBean("secretaryBean",SecretarioEmpleado.class);
          SecretarioEmpleado maria = context.getBean("secretaryBean",SecretarioEmpleado.class);

          /*
          Both should point to the same object (Singleton by default):
          However, once we add scope="prototype" in the bean that deals with the creation of these objects, it will clone them. Thus, the
          objects will be different.
          If we dont state scope="prototype", is the same as stating scope="singleton"
          */
          System.out.println(maria);
          System.out.println(juan);
          
          context.close();
    }
}
