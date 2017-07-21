public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        if (m==0 || n==0 || matrix==null)
            return null;
        
        int[][] res = new int[m][n];
        
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = -1;
                }
            }
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (res[i][j] != 0) {
                    findDistance(res, i, j);
                }
            }
        }
    }
    
    public void findDistance(int[][] res, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        
    }
    
}