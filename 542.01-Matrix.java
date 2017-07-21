public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        if (m==0 || n==0 || matrix==null)
            return null;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x<0 || x>=m || y<0 || y>=n || matrix[x][y] <= matrix[cell[0]][cell[1]]+1)
                    continue;
                queue.offer(new int[] {x, y});
                matrix[x][y] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        
        return matrix;
    }
}