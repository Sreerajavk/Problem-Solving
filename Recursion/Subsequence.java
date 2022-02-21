package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    

    public static void main(String[] args) {
        
        int[] arr = {2,1,3};
        subSeq(0, new ArrayList<>(), arr);
    }


    static void subSeq(int i , List<Integer> list, int[] arr) {

            if(i >= arr.length) {
                for(int val : list) {
                    System.err.print(val);
                }
                System.err.println();
                return;
            }
            list.add(arr[i]);
            subSeq(i+1, list, arr);
            list.remove(list.size() -1 );
            subSeq(i+1, list, arr);
    }
}
