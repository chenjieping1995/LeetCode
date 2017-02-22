public class Solution {
    public String addStrings(String num1, String num2) {
        // 注意，本题中的两个num长度<5100，故本题考察的是大整数的加法
        
        // 先取两个数的长度,初始化进位值
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        
        // 实例化一个StringBuilder类的对象
        StringBuilder sb = new StringBuilder();
        
        // 两个串同时从后往前取数
        for (int i=len1-1, j=len2-1; i>=0 || j>=0 || carry==1; i--, j--){
            int x = i<0 ? 0 : num1.charAt(i)-48;
            int y = j<0 ? 0 : num2.charAt(j)-48;
            sb.append((x+y+carry) % 10);
            carry = (x + y + carry) / 10;
        }
        
        // 逆置并转换为字符串返回
        return sb.reverse().toString();
    }
}