package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
    program to to print the subsequence of an array with specified sum
*/

public class SubsequencWithSum {
    

    public static void main(String[] args) {
        
        int[] arr = { 1,1,1,2,2};
        int sum = 4;
        // subSeqWithSum(0 , arr , 0, new ArrayList<>() , sum);
        // System.err.println("Count : " + countSubSeqWithSum(0,arr,0,sum,0));

        // printAllSubsequencesWithSum(0,arr,sum,new ArrayList<>());

        printUniqueCombinations(0, arr, sum, new ArrayList<>());
    }

    //printing the subsequences with a specific sum
    static void subSeqWithSum(int i, int[] arr, int cumSum , List<Integer> list, int sum) {
        if( i >= arr.length ) {
            if(cumSum == sum) {
                for(int val : list)
                    System.err.print(val);
                System.err.println();
            }
            return;
        }

        list.add(arr[i]);
        subSeqWithSum(i+1, arr, cumSum+arr[i], list, sum);
        list.remove(list.size() - 1);
        subSeqWithSum(i+1, arr, cumSum  ,list, sum);
    }

    //conting the subsequence with a specific sum
    static int countSubSeqWithSum(int i, int[] arr, int cumSum , int sum , int count) {
        if( i >= arr.length ) {
            if(cumSum == sum) {
                return 1;
            }
            return 0;
        }

        int left = countSubSeqWithSum(i+1, arr, cumSum+arr[i], sum,count);
        int right = countSubSeqWithSum(i+1, arr, cumSum , sum,count);

        return left + right;
    }

    //printing all the possible sequence ( combinations ) with repeatition for a specific sum
    static void printAllSubsequencesWithSum(int i , int[] arr , int sum , List<Integer> list) {
        if(i >= arr.length) {
            if(sum == 0) {
                for(int val : list)
                    System.err.print(val);
                System.err.println();
            }
             return;
        }

        if(arr[i] <= sum)  
        { 
            list.add(arr[i]);
            printAllSubsequencesWithSum(i, arr, sum - arr[i], list);
            list.remove(list.size() - 1);
        }      
        printAllSubsequencesWithSum(i+1, arr, sum, list);
    }


    //printing all the unique combinations witha specific sum

    static void printUniqueCombinations(int i , int[] arr , int sum , List<Integer> list) {

        if( sum == 0) {
                for(int val : list)
                    System.err.print(val);
                System.err.println();
            
             return;
        }

        int ele = arr[i];
        if( ele  <= sum ) {
            // list.add(ele);
            // printUniqueCombinations(i+1, arr, sum-arr[i], list);
            // list.remove(list.size() - 1);
            for( int j= i; j < arr.length; j++) {
                if(j > i && arr[j] == ele ) continue;
                
                ele = arr[j];
                list.add(ele);
                printUniqueCombinations(j+1, arr, sum-arr[j], list);
                list.remove(list.size() - 1);
            }
        }
    }
}
