public class Solution {
    public boolean isPalindrome(int x) {
        // 当x<0 或 x为整十数时, 必然不是回文数
        if (x<0 || x!=0 && x%10==0)
            return false;
            
        int res = 0;
        
        while (x>res) {
            res = res*10 + x%10;
            x /= 10;
        }
        
        // 回文数有两种可能: 两边字符对称, 中间有一个单独字符
        return (res==x || x==(res/10));
    }
}