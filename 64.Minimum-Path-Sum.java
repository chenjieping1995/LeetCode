public class Solution {
    public int minPathSum(int[][] grid) {
        // 与之前的方法类似
        // 建立一个m*n的res数组, 第一行每一个数都等于res中前一个数加本身的grid
        // 第一列类似, 其余的每一格取上和左的较小值加本身的值
        
        // 取得数组的高和宽
        int m = grid.length;
        int n = grid[0].length;
        
        // 特殊情况考虑
        if (m<=0 || n<=0)   return 0;
        if (m==1 || n==1) {
            int sum = 0;
            for (int[] i : grid){
                for (int j : i){
                    sum += j;
                }
            }
            return sum;
        }
        
        int [][] res = new int[m][n];
        res[0][0] = grid[0][0];
        
        // 第一行第一列的元素初始化
        for (int i=1; i<m; i++){
            // 第一列
            res[i][0] = res[i-1][0] + grid[i][0];
        }
        for (int i=1; i<n; i++){
            // 第一行
            res[0][i] = res[0][i-1] + grid[0][i];
        }
        
        // 对其余元素的遍历, 逐行逐列
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                res[i][j] = grid[i][j] + Math.min(res[i-1][j], res[i][j-1]);
            }
        }
        
        return res[m-1][n-1];
    }
}