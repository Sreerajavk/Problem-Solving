public class Reverse {

    public static void main(String[] args) {
        
        int[] arr = { 1,2,3,4};
        reverse(arr, 0, arr.length-1);

        // for(int i : arr) {
        //     System.err.println(i);
        // }

        String s = "saass";
        if( palindrome(s,0,s.length()-1) == true) 
            System.err.println("Palindrome");
        else
            System.out.println("Not palindrome");


    }

    public static void  reverse(int[] arr , int i , int n) {
        int temp;
        if(i > n )
            return;
            
        temp = arr[i];
        arr[i] = arr[n];
        arr[n] = temp;

        reverse(arr, i+1, n-1);
       
        
    }

    public static Boolean palindrome(String s  , int l , int h) {
        
        if(l> h)
            return true;
        if(s.charAt(l) != s.charAt(h))
            return false;
        
        return palindrome(s, l+1, h-1);
    }
    
}
