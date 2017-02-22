public class Solution {
    public String addStrings(String num1, String num2) {
        // ע�⣬�����е�����num����<5100���ʱ��⿼����Ǵ������ļӷ�
        
        // ��ȡ�������ĳ���,��ʼ����λֵ
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        
        // ʵ����һ��StringBuilder��Ķ���
        StringBuilder sb = new StringBuilder();
        
        // ������ͬʱ�Ӻ���ǰȡ��
        for (int i=len1-1, j=len2-1; i>=0 || j>=0 || carry==1; i--, j--){
            int x = i<0 ? 0 : num1.charAt(i)-48;
            int y = j<0 ? 0 : num2.charAt(j)-48;
            sb.append((x+y+carry) % 10);
            carry = (x + y + carry) / 10;
        }
        
        // ���ò�ת��Ϊ�ַ�������
        return sb.reverse().toString();
    }
}