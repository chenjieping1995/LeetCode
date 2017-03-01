public class Solution {
    public boolean isPalindrome(int x) {
        // ��x<0 �� xΪ��ʮ��ʱ, ��Ȼ���ǻ�����
        if (x<0 || x!=0 && x%10==0)
            return false;
            
        int res = 0;
        
        while (x>res) {
            res = res*10 + x%10;
            x /= 10;
        }
        
        // �����������ֿ���: �����ַ��Գ�, �м���һ�������ַ�
        return (res==x || x==(res/10));
    }
}