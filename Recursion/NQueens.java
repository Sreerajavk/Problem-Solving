package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
Program to print the the combinations of N queens in a NxN chessbord without conflicting each other
*/
public class NQueens {


    public static void main(String[] args) {
        int n = 4;
        //findDiagonals(n, 2, 2);

        findNQueensPositionsWithList(n, new ArrayList<>(),0,0);
        findNQueensPositionsWithArray(n, new  int[n][n], 0, 0);
    }


    static void findNQueensPositionsWithList(int n, List<List<Integer>> list,int row , int col) {

        if(col >= n) {
            System.err.println(list.toString());
            return;
        }

        for(int i=row; i<n; i++) {
            if(isPlacableWithList(n, list, i, col)) {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                indices.add(col);
                list.add(indices);
                findNQueensPositionsWithList(n, list, 0, col+1);
                list.remove(list.size()-1);
            }
        }
    }

    // checks whether a queen can be placed at index (row,col)
    static Boolean isPlacableWithList(int n , List<List<Integer>> list , int row , int col) {
        int i,j;
        for(List<Integer> index : list) {
            i = index.get(0);
            j = index.get(1);

            if( i == row || j == col) return false;
            if(Math.abs(row-i) == Math.abs(col-j)) return false;
        }

        return true;
    }


    static void findNQueensPositionsWithArray(int n, int[][] indexArray,int row , int col) {

        if(col >= n ) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(indexArray[i][j]);
                }
                System.err.println();
            }
            System.err.println();
            return;
        }

        for(int i=row; i<n; i++) {
            if(isPlacableWithArray(n, indexArray, i, col)) {
                indexArray[i][col] = 1;
                findNQueensPositionsWithArray(n, indexArray, 0, col+1);
                indexArray[i][col] = 0;
            }
        }

    }

    static Boolean isPlacableWithArray(int n , int[][] indexArray , int row , int col) {
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(indexArray[i][j] == 1) {
                    if( i == row || j == col) return false;
                    if(Math.abs(row-i) == Math.abs(col-j)) return false;
                }
            }
        }
        return true;
    }



    // To find all the diagonals of a given index
    static void findDiagonals(int n , int i , int j) {

        int diff;
        for(int ind=0; ind<n; ind++) {

            if(ind == j) continue;
            diff = Math.abs(j-ind);
            if(i+diff < n) {
                System.err.println(i+diff + " " +  ind);
            }
            if(i - diff >= 0) {
                System.err.println(i-diff  + " " + ind);
            }
        }
    }
    
}
