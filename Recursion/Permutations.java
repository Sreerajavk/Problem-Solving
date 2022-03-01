package Recursion;

import java.util.List;
import java.util.*;

/*
Program to print all the permuatations of an array 
*/

public class Permutations {

    public static void main(String[] args) {
        

        int[] arr = { 2,1,3};
        int[] bit = { 0,0,0};

        printAllPermutations(arr , new ArrayList<Integer>() , bit);


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
    
}
