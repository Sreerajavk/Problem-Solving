package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
    Print any one of the sequence with the specified sum
*/
public class AnySubSequenceWithSum {
    

    public static void main(String[] args) {
        
        int[] arr  = {1,2,1};
        int sum = 2;
        anySubseq(0 , new ArrayList<>(), arr, 0 ,sum );

    }

    static boolean anySubseq(int i, List<Integer> list, int[] arr, int curSum , int sum) {

        if(i >= arr.length) {
            if(curSum == sum) {
                for(int val : list)
                    System.err.print(val);
                return true;
            }
            return false;
        }

        //taking the value and call recursion
        list.add(arr[i]);
        if( anySubseq(i+1, list, arr, curSum + arr[i], sum) == true )
            return true;

        //Not taking the value and call recursion
        list.remove(list.size() - 1);
        if( anySubseq(i+1, list, arr, curSum , sum) == true )
            return true;
        return false;
    }
}
