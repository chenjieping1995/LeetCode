public class Solution {
    public String addBinary(String a, String b) {
        
        // ȡ�������ַ����ĳ���
        int len1 = a.length();
        int len2 = b.length();
        
        if (len1 == 0 || len2 == 0)
            return a + b;
            
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        
        int i = len1-1;
        int j = len2-1;
        
        // �Ӻ���ǰ��������ַ�����ÿһλ, �����ӵ�StringBuilderĩβ
        while (i>=0 && j>=0) {
            
            if (a.charAt(i) == '0'){
                if (b.charAt(j) == '0'){
                    // 0+0
                    if (carry) {
                        sb.append("1");
                        carry = false;
                    }
                    else sb.append("0");
                }
                else {
                    // 0+1
                    if (carry) {
                        sb.append("0");
                        carry = true;
                    }
                    else sb.append("1");
                }
            }
            
            else {
                // a.charAt(i) == '1'
                if (b.charAt(j) == '0'){
                    // 1+0
                    if (carry) {
                        sb.append("0");
                        carry = true;
                    }
                    else sb.append("1");
                }
                else {
                    // 1+1
                    if (carry) {
                        sb.append("1");
                        carry = true;
                    }
                    else {
                        sb.append("0");
                        carry = true;
                    }
                }
            }
            
            i--;
            j--;
        }
        
        // ��ĳһ���϶̵��ַ���ֵʱ, ֱ�ӴӺ�ǰ����һ���ַ����ӵ�sb��ĩβ, Ҫ���ǽ�λ
        if (len1 == len2){
            // ����ͬ����, ��ʱֱ�ӿ��ǽ�λ�ͺ�
            if (carry)  {
                sb.append("1");
                carry = false;
            }
        } else if(len1 > len2) {
            while (i>=0){
                // �Ѵ�a��ʣ�ಿ�ּӵ�sbβ��
                if (a.charAt(i) == '1'){
                    if (carry) {
                        // 1+1
                        sb.append("0");
                        carry = true;
                    }
                    else sb.append("1");
                } else {
                    if (carry) {
                        // 0+1
                        sb.append("1");
                        carry = false;
                    }
                    else sb.append("0");
                }
                i--;
            }
        } else {
            // len1 < len2
            while (j>=0){
                // �Ѵ�b��ʣ�ಿ�ּӵ�sbβ��
                if (b.charAt(j) == '1'){
                    if (carry) {
                        // 1+1
                        sb.append("0");
                        carry = true;
                    }
                    else sb.append("1");
                } else {
                    if (carry) {
                        // 0+1
                        sb.append("1");
                        carry = false;
                    }
                    else sb.append("0");
                }
                j--;
            }
        }
        
        if (carry)  sb.append("1");
        
        // ����sb, ��ת�����ַ�����ʽ����
        return sb.reverse().toString();
    }
}