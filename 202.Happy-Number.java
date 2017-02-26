public class Solution {
    public boolean isHappy(int n) {
        // 通过计算可以发现,在个位数中,只有1和7是 happy number
        
        if (n <= 0) return false;
        
        while (true) {
            // 外层循环计算多次的拆解平方和迭代
            
            int sum = 0;
            
            while(n != 0){
                sum += (n%10)*(n%10);
                n /= 10;
            }
            
            if (sum < 10){
                // 如果迭代所得的结果是个位数,进行 happy number 判断
                if ((sum == 1)||(sum == 7)) return true;
                else return false;
            }
            
            n = sum;
        }
    }
}