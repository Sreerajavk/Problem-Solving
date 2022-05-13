package Recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermuation {
    
    public static void main(String[] args) {
        
        int n=3, k=1;
        int[] arr = new int[n];
        int[] bit = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
            bit[i] = 0;
        }
           
        findKthPermuation(arr, n, k, bit, new ArrayList<>(), new ArrayList<>());
        
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
}
