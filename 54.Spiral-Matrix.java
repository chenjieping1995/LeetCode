public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0)  return result;
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        while(true) {
            // 读取最上面一行
            for (int i=left; i<=right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            if (boundriesCrossed(top, bottom, left, right))
                break;
            
            // 读取最右边一列
            for (int i=top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            if (boundriesCrossed(top, bottom, left, right))
                break;
            
            // 读取最下面一行
            for (int i=right; i>=left; i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if (boundriesCrossed(top, bottom, left, right))
                break;
            
            // 读取最左边一列
            for (int i=bottom; i>=top; i--){
                result.add(matrix[i][left]);
            }
            left++;
            if (boundriesCrossed(top, bottom, left, right))
                break;
        }
        
        return result;
    }
    
    // 越界检查函数,越界的话代表以及读完最中心的数
    public boolean boundriesCrossed(int top, int bottom, int left, int right){
        if (top>bottom || left>right)
            return true;
        return false;
    }
}