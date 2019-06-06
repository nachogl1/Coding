/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refreshing_project;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class StringReversingClass {
    //There are 4 ways of doing that at least, I am going to use StringBuffer since it is the way that allows
    //us to concatenate more efficiently
    
    public static void main (String [] args){
        long startTime = System.nanoTime();
        String str = "My favorite athlete is Peter Molar";
        //StringBuffer res=new StringBuffer("");
        StringBuilder res=new StringBuilder(" ");
        for(int i=str.length()-1;i>=0;i--){
           res.append(str.charAt(i));
        }
        
        long endTime = System.nanoTime() - startTime;
        System.out.println(res);
        System.out.println(endTime);
        
        //It was a little bit faster using StringBuilder but this class is not thread-safe
    }
}
