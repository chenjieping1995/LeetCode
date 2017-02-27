public class Solution {
    public int uniquePaths(int m, int n) {
        // һ����Ҫ��(m+n-2)��,ÿһ���������¡�������ѡ��
        // һ����(m-1)����, (n-1)����
        // ȡ(m-1)��(n-1)�еĽ�СֵΪ(x-1), ��Ϊ��(m+n-2)��ѡ��(x-1)�����ܿ�����
        
        if (m<1 || n<1) return 0;
        if (m==1 || n==1) return 1;
        
        // �ܲ���
        int allStep = m+n-2;
        // ��Ҫѡ��Ĳ���
        int choose = Math.max(m-1, n-1);
        
        return helper1(allStep, choose);
    }
    
    public int helper1(int x, int y){
        // ����x!/(y!(x-y)!)��ֵ
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