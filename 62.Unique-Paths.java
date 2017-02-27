public class Solution {
    public int uniquePaths(int m, int n) {
        // 一共需要走(m+n-2)步,每一步可以有下、右两种选择
        // 一共有(m-1)步下, (n-1)步右
        // 取(m-1)和(n-1)中的较小值为(x-1), 则为在(m+n-2)中选择(x-1)个的总可能数
        
        if (m<1 || n<1) return 0;
        if (m==1 || n==1) return 1;
        
        // 总步数
        int allStep = m+n-2;
        // 需要选择的步数
        int choose = Math.max(m-1, n-1);
        
        return helper1(allStep, choose);
    }
    
    public int helper1(int x, int y){
        // 返回x!/(y!(x-y)!)的值
        long result = 1;
        for (int i=y+1; i<=x; i++){
            result *= i;
        }
        
        int n = x-y;
        for (int i=1; i<=n; i++){
            result /= i;
        }
        
        return Integer.parseInt(String.valueOf(result));
    }
}