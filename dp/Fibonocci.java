package dp;

import java.util.Arrays;

public class Fibonocci {



    int[] dp;

    Fibonocci(int n) {
        this.dp = new int[n+1];
        for(int i=0; i<n+1; i++) {
            this.dp[i] = -1;
        }
    }

    public int fib(int n) {

        if(n <= 1) {
            return  n;
        }
        else {
            if(this.dp[n] != -1) {
                return this.dp[n];
            }
            else {
                return this.dp[n] = fib(n-1) + fib(n-2);
            }
        }
    }


    //Driver code
    public static void main(String[] args) {


        int n = 10;
        Fibonocci obj = new Fibonocci(n);
        System.out.println(obj.fib(n));


}
