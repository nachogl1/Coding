/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refreshing_project;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class TreeMapClass {

    public static void main(String[] args) {
        //It also orders the numbers or lexicographly if it is about Strings
      TreeMap<String, Double> treeMap=new TreeMap<>();

      treeMap.put("Paradise Lost", 23.56);
      treeMap.put("Golden Treasury", 12.47);
      treeMap.put("Moon and the Sixpence", 65.28);
      treeMap.put("Holinshed", 7.68);
      treeMap.put("Ancient Mariner", 45.36);

      printAll(treeMap);

      // Keys cannot be duplicates. This will not be stored. It will be updated.
      treeMap.put("Paradise Lost", 23.90);
      printAll(treeMap);

      // Values may be duplicates. This will be stored.
      treeMap.put("Paradise Regained", 23.90);
      printAll(treeMap);
    }
     public static void printAll(TreeMap<String, Double> treeMap){
      for(Map.Entry<String, Double> et:treeMap.entrySet()){
         System.out.println(et.getKey()+": "+et.getValue());
      }
      System.out.println();
   }
}
