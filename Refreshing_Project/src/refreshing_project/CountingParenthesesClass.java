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
public class CountingParenthesesClass {
   public static void main (String[] args){
       String parentheses = "{ d {{ dd e} }} et f{ }{ e{{{{ }e et etg t e  r g  {d{d }}}";
       Map<String,Integer> map=new HashMap<>();
       for(int i=0;i<parentheses.length();i++){
           if(parentheses.charAt(i)=='{'){
               if(!map.containsKey("{")){
                   map.put("{", 1);
               }else{
                   map.put("{",map.get("{")+1);
               }
           }
           if(parentheses.charAt(i)=='}'){
               if(!map.containsKey("}")){
                   map.put("}", 1);
               }else{
                   map.put("}",map.get("}")+1);
               }
           }
       }
       System.out.println("The number of '{' is "+map.get("{"));
       System.out.println("The number of '}' is "+map.get("}"));      
   }
}
