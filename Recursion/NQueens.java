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

        findNQueensPositions(n, new ArrayList<>(),0,0);
    }


    static void findNQueensPositions(int n, List<List<Integer>> list,int row , int col) {
         
        if(col >= n) {
            System.err.println(list.toString());
            return;
        }

        for(int i=row; i<n; i++) {
            if(isPlacable(n, list, i, col)) {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                indices.add(col);
                list.add(indices);
                findNQueensPositions(n, list, 0, col+1);
                list.remove(list.size()-1);
            }
        }
    }

    // checks whether a queen can be placed at index (row,col)
    static Boolean isPlacable(int n , List<List<Integer>> list , int row , int col) {
        int i,j;
        for(List<Integer> index : list) {
            i = index.get(0);
            j = index.get(1);

            if( i == row || j == col) return false;
            if(Math.abs(row-i) == Math.abs(col-j)) return false;
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
