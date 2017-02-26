public class Solution {
    public int lengthOfLastWord(String s) {
        
        int result = 0;
        
        // 先去除字符串首尾的空格,再取字符串长度
        s = s.trim();
        int len = s.length();
        
        // 从后往前判断
        for (int i=len-1; i>=0; i--) {
            if ((Character.isLowerCase(s.codePointAt(i))) || (Character.isUpperCase(s.codePointAt(i)))){
                result++;//表示当前读到了字符
            }
            else break;
        }
        
        return result;
    }
}