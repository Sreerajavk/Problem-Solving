package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
    Program to print all the subsequence in an array
*/

public class Subsequence {
    

    public static void main(String[] args) {
        
        int[] arr = {2,3,6,7,5,8};
        //subSeq(0, new ArrayList<>(), arr);
        subSeqOfSizeK(0, new ArrayList<>(), arr,2);
    }


    static void subSeq(int i , List<Integer> list, int[] arr) {

            if(i >= arr.length) {
                for(int val : list) {
                    System.err.print(val);
                }
                System.err.println();
                return;
            }
            //taking the element and calling recursion
            list.add(arr[i]);
            subSeq(i+1, list, arr);

            //not taking the element and calling recursion
            list.remove(list.size() -1 );
            subSeq(i+1, list, arr);
    }

    static void subSeqOfSizeK(int i , List<Integer> list, int[] arr, int k) {

        if(i >= arr.length ) {

            if(list.size() == k) {
                for(int val : list) {
                    System.err.print(val);
                }
                System.err.println();
            }
            return;
        }
        //taking the element and calling recursion
        list.add(arr[i]);
        subSeqOfSizeK(i+1, list, arr,k);

        //not taking the element and calling recursion
        list.remove(list.size() -1 );
        subSeqOfSizeK(i+1, list, arr,k);
    }
}
