public class Solution {
    public int minPathSum(int[][] grid) {
        // ��֮ǰ�ķ�������
        // ����һ��m*n��res����, ��һ��ÿһ����������res��ǰһ�����ӱ����grid
        // ��һ������, �����ÿһ��ȡ�Ϻ���Ľ�Сֵ�ӱ����ֵ
        
        // ȡ������ĸߺͿ�
        int m = grid.length;
        int n = grid[0].length;
        
        // �����������
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
        
        // ��һ�е�һ�е�Ԫ�س�ʼ��
        for (int i=1; i<m; i++){
            // ��һ��
            res[i][0] = res[i-1][0] + grid[i][0];
        }
        for (int i=1; i<n; i++){
            // ��һ��
            res[0][i] = res[0][i-1] + grid[0][i];
        }
        
        // ������Ԫ�صı���, ��������
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                res[i][j] = grid[i][j] + Math.min(res[i-1][j], res[i][j-1]);
            }
        }
        
        return res[m-1][n-1];
    }
}