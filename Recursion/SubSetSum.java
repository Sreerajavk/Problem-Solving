package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    program to print all possible subset sum in increasing order
*/
public class SubSetSum {
    
    public static void main(String[] args) {
        
        int[] arr = {3,1,2};
        List<Integer> sumList = new ArrayList<>();
        findAllSubsetSum(0, arr, 0, sumList);
        Collections.sort(sumList);
        for(Integer i : sumList) {
            System.err.print(i + " ");
        }

        findAllSubsets(0, arr, new ArrayList<>());
    }


    // Functoin to print all subset sums
    static void  findAllSubsetSum(int i , int[] arr , int sum, List<Integer> sumList) {

        if( i >= arr.length ) {
            sumList.add(sum);
            return;
        }

        // pick the item at index i
        findAllSubsetSum(i+1, arr, sum+arr[i],sumList);

        // not pick the item at index i
        findAllSubsetSum(i+1, arr, sum,sumList);
        
    }

    // Function to print all the all possible subsets
    static void  findAllSubsets(int i , int[] arr , List<Integer> list) {

        if( i >= arr.length ) {
            for(Integer ele : list) {
                System.err.print(ele + " ");
            }
            System.err.println();
            return;
        }

        // pick the item at index i
        list.add(arr[i]);
        findAllSubsets(i+1, arr,list);

        // not pick the item at index i
        list.remove(list.size() - 1);
        findAllSubsets(i+1, arr, list);
        
    }
}
