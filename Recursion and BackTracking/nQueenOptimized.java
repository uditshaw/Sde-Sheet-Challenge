import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<String>> ans;
    static void storeMatrix(boolean[][] board)
    {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < board.length; i++)
        {
            String w = "";
            for(int j = 0; j < board[i].length; j++)
            {
                if( board[i][j] )
                    w += "Q";
                else w+= ".";
            }
            res.add(w);
        }
        ans.add(res);    
    }
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<List<String>>();
        
        if( n == 1 )
        {
            List<String> nq = new ArrayList<String>();
            nq.add("Q");
            ans.add(nq);  
            return ans;
        }
        
        boolean board[][] = new boolean[n][n];
        boolean leftRow[] = new boolean[n];
        boolean upDiagonal[] = new boolean[2*n -1];
        boolean lowDiagonal[] = new boolean[2*n -1];
        
        solveRec(0, board, leftRow, upDiagonal, lowDiagonal);

        return ans;
    }
    void solveRec(int col, boolean board[][], boolean leftRow[], boolean upDiagonal[], boolean lowDiagonal[])
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
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.solveNQueens(4));
    }
}