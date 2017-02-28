public class Solution {
    public int[] plusOne(int[] digits) {
        // 取出数组长度len
        // 从最后一位开始, 维护一个进位标志carry
        // 如果第一位也要进位, 就要new一个新数组
        int len = digits.length;
        
        // 不需要进位
        if (digits[len-1] != 9){
            digits[len-1] = digits[len-1] + 1;
            return digits;
        }
        digits[len-1] = 0;
        
        boolean carry = true;
        
        int i=len-2;
        while(carry && i>=0) {
            if (digits[i] != 9){
                // 该位不为9, 进位到此结束
                carry = false;
                digits[i] += 1;
                return digits;
            }
            else {
                // 该位仍为9继续进位
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