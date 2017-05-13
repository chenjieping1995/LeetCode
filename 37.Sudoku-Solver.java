public class Solution {
    // backtracking method
    public void solveSudoku(char[][] board) {
        // corner case
        if (board==null || board.length!=9 || board[0].length!=9) {
            return;
        }
        backtrack(board, 0, 0);
        return ;
    }
    
    // backtracking
    public boolean backtrack(char[][] board, int i, int j) {
        if (j>=9){
            return backtrack(board, i+1, 0);
        }
        if (i==9)
            return true;
        if (board[i][j]=='.') {
            for (int k=1; k<=9; k++) {
                board[i][j]=(char)(k+'0');
                if (isValid(board, i, j)){
                    if (backtrack(board, i, j+1))
                        return true;
                }
                // cancel assignment
                board[i][j]='.';
            }
        }
        else {
            return backtrack(board, i, j+1);
        }
        return false;
    }
    
    // check validate function
    public boolean isValid(char[][] board, int i, int j) {
        // check row
        for (int k=0; k<9; k++) {
            if (k!=j && board[i][k]==board[i][j])
                return false;
        }
        
        // check column
        for (int k=0; k<9; k++) {
            if (k!=i && board[k][j]==board[i][j])
                return false;
        }
        
        // check block
        int m = i/3*3;  // start row
        int n = j/3*3;  // start column
        for (int a=m; a<m+3; a++) {
            for (int b=n; b<n+3; b++) {
                if (a!=i || b!=j) {
                    if (board[a][b]==board[i][j])
                        return false;
                }
            }
        }
        return true;
    }
}