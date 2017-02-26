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
                // 写入顶行
                result[top][j] = i;
                i++;
            }
            top++;
            if (i == n*n+1)   break;
            
            for (int j=top; j<=bottom; j++){
                // 写入右列
                result[j][right] = i;
                i++;
            }
            right--;
            if (i == n*n+1)   break;
        
            for (int j=right; j>=left; j--){
                // 写入底行
                result[bottom][j] = i;
                i++;
            }
            bottom--;
            if (i == n*n+1)   break;
            
            for (int j=bottom; j>=top; j--){
                // 写入左列
                result[j][left] = i;
                i++;
            }
            left++;
            if (i == n*n+1)   break;
        }
        
        return result;
    }
}