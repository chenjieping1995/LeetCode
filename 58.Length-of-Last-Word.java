public class Solution {
    public int lengthOfLastWord(String s) {
        
        int result = 0;
        
        // ��ȥ���ַ�����β�Ŀո�,��ȡ�ַ�������
        s = s.trim();
        int len = s.length();
        
        // �Ӻ���ǰ�ж�
        for (int i=len-1; i>=0; i--) {
            if ((Character.isLowerCase(s.codePointAt(i))) || (Character.isUpperCase(s.codePointAt(i)))){
                result++;//��ʾ��ǰ�������ַ�
            }
            else break;
        }
        
        return result;
    }
}