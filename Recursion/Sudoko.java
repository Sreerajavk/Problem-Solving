package Recursion;

public class Sudoko {

    public static void main(String[] args) {

        int n = 9;
        int[][] sudokoArray = { { 5, 3, 0, 6, 7, 8, 9, 0, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
                { 0, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
                { 7, 1, 3, 9, 0, 4, 8, 5, 6 }, { 9, 6, 0, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
                { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

        //printIndices(0,3);
        solveSudoko(sudokoArray, 0, 0,n);
        // for(int i=0; i<9; i++) {
        //     for(int j=0; j<9; j++) {
        //         System.err.print(sudokoArray[i][j]);
        //     }
        //     System.err.println();
        // }

    }

    static void solveSudoko(int[][] arr , int row , int col , int n) {
        // if(row == 8 && col == 8) {
        //     for(int i=0; i<9; i++) {
        //         for(int j=0; j<9; j++) {
        //             System.err.print(arr[i][j]);
        //         }
        //         System.err.println();
        //     }
        //     return;
        // }
            
        
        for(int i=row; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 0) {
                    for(int k=1; k<=n; k++) {
                        if(isPlacable(arr, i, j, k, n)) {
                            arr[i][j] = k;
                            solveSudoko(arr, (i + (j/9)), ((j + 1 )%9) ,n);
                            arr[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.err.print(arr[i][j]);
            }
            System.err.println();
        }
    }

    // determines wether the a digit(num) is placble at (row,col)
    static Boolean isPlacable(int[][] arr , int row , int col, int num , int n) {

        int rowStart = (row/3 ) * 3;
        int colStart = (col/3) * 3;

        for(int i=0; i<n; i++) {
            if(arr[row][i] == num) return false; // checking the row
            if(arr[i][col] == num) return false;  // checking the column
            if(arr[(i / 3)+rowStart][(i % 3)+colStart] == num) return false; // checking the 3x3 small cube
        }
        return true;
    }

    static void printIndices(int row , int col) {
        int rowStart = (row/3 ) * 3;
        int colStart = (col/3) * 3;

        //System.err.println(rowStart + " " + colStart);
        for(int i=0; i<9; i++) {
            System.err.print((i / 3)+rowStart);
            System.err.print((i % 3)+colStart);
            System.err.println();
        }
    }

}
