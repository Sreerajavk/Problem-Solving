package Recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermuation {
    
    public static void main(String[] args) {
        
        int n=4, k=17;
        int[] arr = new int[n];
        int[] bit = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
            bit[i] = 0;
        }
           
        // findKthPermuation(arr, n, k, bit, new ArrayList<>(), new ArrayList<>());
        findKthPermuationOptimsed(arr, n, k, new ArrayList<>());
        
    }

     static void findKthPermuation(int[] arr , int n , int k,int[] bit, List<Integer> list, List<List<Integer>> ans) {

        if(list.size() == n) {
            ans.add(list);
            if(ans.size() == k)
                System.err.println(list.toString());
            return;
        }

        for(int i=0; i<n; i++) {
            if(bit[i] == 0) {
                bit[i] = 1;
                list.add(arr[i]);
                findKthPermuation(arr, n, k, bit, list ,  ans );
                bit[i] = 0;
                list.remove(list.size()-1);
                
            }
        }
    }

    static void findKthPermuationOptimsed(int[] arr , int n , int k , List<Integer> list) {

        int offset;
        int temp = n;
        while(list.size() != n) {
            offset = k / factorial(temp-1);
            list.add(arr[offset]);
            k = k % factorial(temp-1);
            temp--;
            removeElementFromArray(arr, offset, n);
        }

        System.err.println(list.toString());
    }

    static void removeElementFromArray(int[] arr , int k , int n) {

        for(int i=k; i<n-1;i++) {
            arr[i] = arr[i+1];
        }
    }

    static int factorial(int n) {

        if(n == 1 || n == 0) return 1;

        return n * factorial(n-1);
    }
}
