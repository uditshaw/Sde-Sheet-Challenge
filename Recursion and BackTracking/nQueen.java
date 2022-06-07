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
        solveRec(0, board);

        return ans;
    }
    void solveRec(int col, boolean board[][])
    {
        if( col == board.length ) storeMatrix(board);
        for (int i = 0 ; i < board.length; i++)
        {
            if( isSafe(i, col, board) )
            {
                board[i][col] = true;
                solveRec(col+1, board);
                board[i][col] = false;
            }
        }
    }
    boolean isSafe(int row, int col, boolean board[][]) {
        for (int i = 0; i < col; i++) {
            if (board[row][i])
                return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false;
        }
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.solveNQueens(4));
    }
}