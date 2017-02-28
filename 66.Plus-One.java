public class Solution {
    public int[] plusOne(int[] digits) {
        // ȡ�����鳤��len
        // �����һλ��ʼ, ά��һ����λ��־carry
        // �����һλҲҪ��λ, ��Ҫnewһ��������
        int len = digits.length;
        
        // ����Ҫ��λ
        if (digits[len-1] != 9){
            digits[len-1] = digits[len-1] + 1;
            return digits;
        }
        digits[len-1] = 0;
        
        boolean carry = true;
        
        int i=len-2;
        while(carry && i>=0) {
            if (digits[i] != 9){
                // ��λ��Ϊ9, ��λ���˽���
                carry = false;
                digits[i] += 1;
                return digits;
            }
            else {
                // ��λ��Ϊ9������λ
                digits[i] = 0;
                i--;
                continue;
            }
        }
        
        //
        int[] res = new int[len+1];
        res[0] = 1;
        for (int x=1; x<=len; x++){
            res[x] = 0;
        }
        return res;
    }
}