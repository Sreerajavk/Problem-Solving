package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.lang.model.element.Element;

import org.omg.PortableInterceptor.INACTIVE;

/*
    program to print all possible subset sum in increasing order
*/
public class SubSetSum {
    
    public static void main(String[] args) {
        
        int[] arr = {1,1,2,3};
        List<Integer> sumList = new ArrayList<>();

        
        findAllSubsetSum(0, arr, 0, sumList);
        Collections.sort(sumList);
        for(Integer i : sumList) {
            System.err.print(i + " ");
        }


        findAllSubsets(0, arr, new ArrayList<>());


        List<List<Integer>> output = new ArrayList<>(); 
        printUniqueSubsets(0, arr, new ArrayList<>(), output);
        for(List<Integer> list : output) {
            System.err.println(list.toString());
        }

    }


    // Function to print all subset sums
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


    //Function to print all unique subsets in an array ( eliminate duplicates )
    static void printUniqueSubsets(int i , int[] arr , List<Integer> list, List<List<Integer>> output)  {

        output.add(new ArrayList<>(list));

        for(int j=i; j < arr.length; j++) {
            if(j > i && arr[j] == arr[j-1]) continue;
            list.add(arr[j]);
            printUniqueSubsets(j+1, arr, list, output);
            list.remove(list.size() - 1);
        }
    }
}
