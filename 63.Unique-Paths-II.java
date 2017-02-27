public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        // ȡ�þ��εĳ�m, ��n
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
        
        // ��̬�滮������ֵ, res[0][0]Ϊ1
        int[][] res = new int[m][n];
        res[0][0] = 1;
        
        // ���������к�������, ֮ǰû���ϰ��Ķ���1, �����ϰ�������и��Ӷ���ֵΪ0
        boolean flag = true;    // ǰ�����ϰ���ʾ
        for (int i=1; i<n; i++){
            // �����еĸ�ֵ����
            if (obstacleGrid[0][i] == 1)
                flag = false;
            if (flag)   res[0][i] = 1;
            else res[0][i] = 0;
        }
        
        flag = true;    // ǰ�����ϰ���ʾ
        for (int i=1; i<m; i++){
            // �����еĸ�ֵ����
            if (obstacleGrid[i][0] == 1)
                flag = false;
            if (flag)   res[i][0] = 1;
            else res[i][0] = 0;
        }
        
        // �������еض�̬�滮����res����, ���ϰ�ʱ, ֵΪ�����, ����Ϊ0
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if (obstacleGrid[i][j] == 1)
                    res[i][j] = 0;
                else res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        
        // ���ؽ��
        return res[m-1][n-1];
    }
}