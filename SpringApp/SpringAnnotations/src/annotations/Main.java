/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotations;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext8.xml");
        Libro libro = (Libro) factory.getBean("libro");
        System.out.println("- " + libro.getTitulo());
        System.out.println("- " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellido());
        System.out.println("- " + libro.getEditorial());
        System.out.println("- " + libro.getGenero());
        System.out.println("- " + libro.getEdicion());
        System.out.println("- " + libro.getPaginas());
    }
}