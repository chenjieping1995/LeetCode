public class Solution {
    public int climbStairs(int n) {
        // ����n==1��2ʱ, res[n]==1��2
        if (n == 1) return 1;
        else if (n == 2)    return 2;
        
        int[] res = new int [n+1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        
        // n>=3ʱ, ÿһ�ε�res[n] = res[n-1] + res[n-2]
        // �����ǵõ�n֮ǰ��һ���ǿ���2����1��
        for (int i=3; i<=n; i++){
            res[i] = res[i-1] + res[i-2];
        }
        
        return res[n];
    }
}