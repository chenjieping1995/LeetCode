public class Solution {
    public int climbStairs(int n) {
        // 对于n==1、2时, res[n]==1、2
        if (n == 1) return 1;
        else if (n == 2)    return 2;
        
        int[] res = new int [n+1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        
        // n>=3时, 每一次的res[n] = res[n-1] + res[n-2]
        // 即考虑得到n之前的一步是跨了2格还是1格
        for (int i=3; i<=n; i++){
            res[i] = res[i-1] + res[i-2];
        }
        
        return res[n];
    }
}