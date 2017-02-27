public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        // 取得矩形的长m, 高n
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if (m <= 0 || n <= 0)   return 0;
        
        if (m == 1 || n == 1){
            for (int[] i : obstacleGrid){
                for (int j : i){
                    if (j == 1) return 0;
                }
            }
            return 1;
        }
        
        if (obstacleGrid[0][0] == 1)    return 0;
        
        // 动态规划法赋初值, res[0][0]为1
        int[][] res = new int[m][n];
        res[0][0] = 1;
        
        // 对于最左列和最上行, 之前没有障碍的都是1, 遇到障碍后的所有格子都赋值为0
        boolean flag = true;    // 前方无障碍提示
        for (int i=1; i<n; i++){
            // 最上行的赋值操作
            if (obstacleGrid[0][i] == 1)
                flag = false;
            if (flag)   res[0][i] = 1;
            else res[0][i] = 0;
        }
        
        flag = true;    // 前方无障碍提示
        for (int i=1; i<m; i++){
            // 最上行的赋值操作
            if (obstacleGrid[i][0] == 1)
                flag = false;
            if (flag)   res[i][0] = 1;
            else res[i][0] = 0;
        }
        
        // 逐行逐列地动态规划遍历res数组, 无障碍时, 值为左加上, 否则为0
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if (obstacleGrid[i][j] == 1)
                    res[i][j] = 0;
                else res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        
        // 返回结果
        return res[m-1][n-1];
    }
}