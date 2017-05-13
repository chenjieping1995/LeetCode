public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // detect rows
        for (int i=0; i<9; i++) {
            boolean[] rows = new boolean[9];
            for (int j=0; j<9; j++) {
                if (board[i][j]=='.') continue;
                else {
                    int k = Integer.parseInt(board[i][j]+"")-1;
                    if (rows[k]==false)  rows[k]=true;
                    else return false;
                }
            }
        }
        
        // detect columns
        for (int i=0; i<9; i++) {
            boolean[] columns = new boolean[9];
            for (int j=0; j<9; j++) {
                if (board[j][i]=='.') continue;
                else {
                    int k = Integer.parseInt(board[j][i]+"")-1;
                    if (columns[k]==false)  columns[k]=true;
                    else return false;
                }
            }
        }
        
        // detect blocks
        for (int a=0; a<3; a++) {
            for (int b=0; b<3; b++) {
                int i = 3*a;
                int j = 3*b;
                boolean[] blocks = new boolean[9];
                for (int m=0; m<3; m++) {
                    for (int n=0; n<3; n++) {
                        if (board[i+m][j+n]=='.')   continue;
                        else {
                            int k = Integer.parseInt(board[i+m][j+n]+"")-1;
                            if (blocks[k]==false)   blocks[k]=true;
                            else return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}