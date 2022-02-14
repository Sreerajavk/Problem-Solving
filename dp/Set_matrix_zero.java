package dp;


/*
problem description
https://leetcode.com/problems/set-matrix-zeroes/
*/


public class Set_matrix_zero {

    public static void main(String[] args) {
        
        int[][] matrix = {{1,1,1,},{1,0,1},{1,1,1}};

        int m = matrix.length;
        int n = matrix[0].length;

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
    }
    
}
