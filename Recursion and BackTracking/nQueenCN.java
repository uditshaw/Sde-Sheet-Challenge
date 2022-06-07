import java.util.*;
public class Solution {
    static ArrayList<ArrayList<Integer>> ans;
    
     static void storeMatrix(boolean[][] board)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if( board[i][j] )
                    res.add(1);
                else res.add(0);
            }
        }
        ans.add(res);    
    }
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        // Write your code here.
        ans = new ArrayList<ArrayList<Integer>>();
        
        if( n == 1 )
        {
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(1);
            ans.add(res);
            return ans;
        }
        
        boolean board[][] = new boolean[n][n];
        boolean leftRow[] = new boolean[n];
        boolean upDiagonal[] = new boolean[2*n -1];
        boolean lowDiagonal[] = new boolean[2*n -1];
        
        solveRec(0, board, leftRow, upDiagonal, lowDiagonal);

        return ans;
    }
    static void solveRec(int col, boolean board[][], boolean leftRow[], boolean upDiagonal[], boolean lowDiagonal[])
    {
        if( col == board.length ) storeMatrix(board);     
        
        for (int row = 0 ; row < board.length; row++)
        {
            if( leftRow[row] == false && lowDiagonal[row+col] == false && upDiagonal[board.length - 1 + col - row] == false )
            {
                board[row][col] = true;
                leftRow[row] = true;
                lowDiagonal[row+col] = true;
                upDiagonal[board.length - 1 + col - row] = true;

                solveRec(col+1, board, leftRow, upDiagonal, lowDiagonal);

                board[row][col] = false;
                leftRow[row] = false;
                lowDiagonal[row+col] = false;
                upDiagonal[board.length - 1 + col - row] = false;
            }
        }
    }
   
}