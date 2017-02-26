public class Solution {
    public boolean isHappy(int n) {
        // ͨ��������Է���,�ڸ�λ����,ֻ��1��7�� happy number
        
        if (n <= 0) return false;
        
        while (true) {
            // ���ѭ�������εĲ��ƽ���͵���
            
            int sum = 0;
            
            while(n != 0){
                sum += (n%10)*(n%10);
                n /= 10;
            }
            
            if (sum < 10){
                // ����������õĽ���Ǹ�λ��,���� happy number �ж�
                if ((sum == 1)||(sum == 7)) return true;
                else return false;
            }
            
            n = sum;
        }
    }
}