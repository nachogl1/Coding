/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refreshing_project;

import java.util.Arrays;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class SelectionSortClass {

    public static void main(String[] args) {

        int[] a = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};
        int i, j, k, pos, temp;
        for (i = 0; i < a.length; i++) {
            pos = smallest(a, a.length, i);
            temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;
        }
        System.out.println("\nprinting sorted elements...\n");
        System.out.print(Arrays.toString(a));
        //for(int num:a){System.out.println(num);}
    }

    public static int smallest(int a[], int n, int i) {
        int small, pos, j;
        small = a[i];
        pos = i;
        for (j = i + 1; j < a.length; j++) {
            if (a[j] < small) {
                small = a[j];
                pos = j;
            }
        }
        return pos;
    }
}
