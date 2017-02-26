public class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] result = new int[n][n];
        
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        
        int i = 1;
        
        while (true) {
            
            for (int j=left; j<=right; j++){
                // д�붥��
                result[top][j] = i;
                i++;
            }
            top++;
            if (i == n*n+1)   break;
            
            for (int j=top; j<=bottom; j++){
                // д������
                result[j][right] = i;
                i++;
            }
            right--;
            if (i == n*n+1)   break;
        
            for (int j=right; j>=left; j--){
                // д�����
                result[bottom][j] = i;
                i++;
            }
            bottom--;
            if (i == n*n+1)   break;
            
            for (int j=bottom; j>=top; j--){
                // д������
                result[j][left] = i;
                i++;
            }
            left++;
            if (i == n*n+1)   break;
        }
        
        return result;
    }
}