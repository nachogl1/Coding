package IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class LifeCycleOfBeans {
    public static void main(String[] args) {

          ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
          DirectorEmpleado juan = context.getBean("directorBean",DirectorEmpleado.class);
          System.out.println(juan.getTasks());
          System.out.println(juan.getInforme());
          context.close();
    }
}
