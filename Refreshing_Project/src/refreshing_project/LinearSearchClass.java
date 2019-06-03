/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refreshing_project;

import java.util.Scanner;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class LinearSearchClass {
    public static void main(String[] args) { 
        //Non-ordered
  int[] arr = {10, 23, 15, 8, 4, 3, 25, 30, 34, 2, 19};  
  int item,flag=0;   
  Scanner sc = new Scanner(System.in);  
  System.out.println("Enter Item ?");  
  item = sc.nextInt();  
  for(int i = 0; i<arr.length; i++)  
  {  
    if(arr[i]==item)  
    {  
      flag = i+1;  
      break;  
    }  
    else   
      flag = 0;   
  }  
  if(flag != 0)  
  {  
    System.out.println("Item found at location: " + flag);  
  }  
  else   
    System.out.println("Item not found");  
    
}  
}
