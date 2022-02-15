package dp;


/*
problem description
https://leetcode.com/problems/set-matrix-zeroes/
*/


public class Set_matrix_zero {

    public static void main(String[] args) {
        
        int[][] matrix = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}}
        ;

        int m = matrix.length;
        int n = matrix[0].length;

        // solution in which time complexity is O(n*m) and space complexity of O(N+M)
        int[] rows = new int[m];
        int[] columns = new int[n];

        for(int i=0; i<m;i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = 1;
                    columns[j] = 1;
                }
                    
            }
        }

        for(int i=0; i<m;i++) {
            for(int j=0; j<n; j++) {
                if(rows[i] == 1 || columns[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

        // optimisedSolution(matrix, m, n);
    }

    public  void optimisedSolution(int[][] matrix , int  m , int n) {

        // solution in which time complexity is O(n*m) and space complexity of O(1)
        Boolean column = false;
        for(int i=0; i<m;i++) {
            if(matrix[i][0] == 0)
                column = true;
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
                    
            }
        }

        for(int i=m-1; i>=0;i--) {
            for(int j=n-1; j>=0; j--) { 
                
                if(j == 0 ) {
                    if(column == true)
                         matrix[i][0] = 0;
                } else {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }  
            }
        }

        for(int i=0; i<m;i++) {
            for(int j=0; j<n; j++) {
                System.err.println(matrix[i][j]);
            }
        }

    }
    
}
