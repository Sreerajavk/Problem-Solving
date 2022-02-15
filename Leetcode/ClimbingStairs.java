

package Leetcode;

/*
Problem satement
https://leetcode.com/problems/climbing-stairs/
*/

public class ClimbingStairs{

    public static void main(String[] args) {

        // dp solution
        int n = 10;
        int[] dp = new int[n+1];

        //base cases
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i=2; i<n; i++ ){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        System.err.println("No of ways : " + dp[n-1]);
    }
}