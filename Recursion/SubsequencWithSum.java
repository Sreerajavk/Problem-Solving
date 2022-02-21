package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
    program to to print the subsequence of an array with specified sum
*/

public class SubsequencWithSum {
    

    public static void main(String[] args) {
        
        int[] arr = { 1, 2, 1};
        int sum = 2;
        subSeqwithSum(0 , arr , 0, new ArrayList<>() , sum);
    }

    static void subSeqwithSum(int i, int[] arr, int cumSum , List<Integer> list, int sum) {
        if( i >= arr.length ) {
            if(cumSum == sum) {
                for(int val : list)
                    System.err.print(val);
                System.err.println();
            }
            return;
        }

        list.add(arr[i]);
        subSeqwithSum(i+1, arr, cumSum+arr[i], list, sum);
        list.remove(list.size() - 1);
        subSeqwithSum(i+1, arr, cumSum  ,list, sum);
    }
}
