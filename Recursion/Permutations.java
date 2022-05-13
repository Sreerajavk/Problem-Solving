package Recursion;

import java.util.List;
import java.util.*;

/*
Program to print all the permuatations of an array 
*/

public class Permutations {

    public static void main(String[] args) {
        

        int[] arr = { 1,2,3,4};
        int[] bit = { 0,0,0};

        //printAllPermutations(arr , new ArrayList<Integer>() , bit);
        printAllPermutationsOptimised(0, arr);
    }

    static void printAllPermutations(int[] arr , List<Integer> list, int[] bit) {

        if(list.size() == arr.length) {
            System.out.println(list.toString());
            return;
        }

        for( int i=0; i<arr.length; i++) {

            if(bit[i] == 0) {
                bit[i] = 1;
                list.add(arr[i]);
                printAllPermutations(arr , list, bit);
                bit[i] = 0;
                list.remove(list.size() -1);
            }

        }
    }

    static void printAllPermutationsOptimised(int i , int[] arr) {

        if( i >= arr.length ) {
            for(int ele : arr) {
                System.err.print(ele);
            }
            System.err.println();
            return;
        }

        for(int j=i; j<arr.length; j++) {
            swap(i, j, arr);
            printAllPermutationsOptimised(i+1, arr);
            swap(i, j, arr);
        }
    }

    static void swap(int first , int second , int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    
}
