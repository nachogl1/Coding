/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refreshing_project;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class TreeSetClass {
    //To run this main click on the screen and select run instead of clicking on the run symbol in the toolbar
    //It follows lexicographic order for strings and numeric order for numbers like Integers
    public static void main(String[] args) {
      //Integer[] nums={2,4,1,6,3,7,9,5};
      //SortedSet<Integer> tree=new TreeSet<>(Arrays.asList(nums));
      String[] nums={"Hola","que","tal"};
      SortedSet<String> tree=new TreeSet<>(Arrays.asList(nums));
        
      // Print first and last element
      System.out.println(tree.first());
      System.out.println(tree.last());
      System.out.println("Whole tree");
      printAll(tree);
      // False. Set does not allow duplicates,
      // so this will not be added.
      System.out.println(tree.add("Hola"));

      // But, this will be added because 11 is not a duplicate
      System.out.println(tree.add("pepe"));
      System.out.println(tree.add("miau"));
      printAll(tree);
      System.out.println("HeadSet 7");
      printAll(tree.headSet("Hola"));
      System.out.println("TailSet 7");
      printAll(tree.tailSet("miau"));
    }
    public static void printAll(SortedSet<String> tree){
      for(String s: tree){
         System.out.println(s);
      }
      System.out.println();
   }
}
