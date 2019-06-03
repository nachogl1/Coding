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
public class BubbleSortClass {

    public static void main(String[] args) {
        int[] a = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                //Descending order
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    for (int num : a) {
                        System.out.print(num+" ");
                    }
                    System.out.println("");
                }
            }
        }
        System.out.println("Printing Sorted List ...");
        for (int num : a) {
            System.out.println(num);
        }
    }
}
