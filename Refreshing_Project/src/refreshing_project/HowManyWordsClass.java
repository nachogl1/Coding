/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refreshing_project;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class HowManyWordsClass {
    public static void main(String[] args){
     String parentheses = "{ d {{ dd e} }} et f{ }{ e{{{{ }e et etg t e  r g  {d{d }}}";
       Map<Character,Integer> map=new HashMap<>();
       for(int i=0;i<parentheses.length();i++){
           if(!map.containsKey(parentheses.charAt(i))){
               map.put(parentheses.charAt(i), 1);
           }else{
               map.put(parentheses.charAt(i), map.get(parentheses.charAt(i))+1);
           }
       }
       for(Character key:map.keySet()){
           System.out.println("The letter '"+key+"' appears "+map.get(key)+" times");
       }
       
       String parentheses2 = "Hola que tal como estamos, todo bien? Hola hola";
       parentheses2= parentheses2.toLowerCase();
       String[] words = parentheses2.split("\\W+");
       Map<String,Integer> map2=new HashMap<>();
       for(int j=0;j<words.length;j++){
           if(!map2.containsKey(words[j])){
               map2.put(words[j], 1);
           }else{
               map2.replace(words[j], map2.get(words[j])+1);
           }
       }
       for(String key:map2.keySet()){
           System.out.println("The letter '"+key+"' appears "+map2.get(key)+" times");
       } 
   }
}
