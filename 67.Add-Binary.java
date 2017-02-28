public class Solution {
    public String addBinary(String a, String b) {
        
        // 取得两个字符串的长度
        int len1 = a.length();
        int len2 = b.length();
        
        if (len1 == 0 || len2 == 0)
            return a + b;
            
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        
        int i = len1-1;
        int j = len2-1;
        
        // 从后向前相加两个字符串的每一位, 结果添加到StringBuilder末尾
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
        
        // 当某一个较短的字符无值时, 直接从后到前把另一个字符串加到sb的末尾, 要考虑进位
        if (len1 == len2){
            // 两串同长度, 此时直接考虑进位就好
            if (carry)  {
                sb.append("1");
                carry = false;
            }
        } else if(len1 > len2) {
            while (i>=0){
                // 把串a的剩余部分加到sb尾部
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
                // 把串b的剩余部分加到sb尾部
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
        
        // 逆置sb, 并转换成字符串形式返回
        return sb.reverse().toString();
    }
}