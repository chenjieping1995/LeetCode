public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int count = 0;
        for (int i=len-1; i>=0; i--){
            char x = s.charAt(i);
            int a = x - 'A' + 1;
            for (int j=len-1-i; j>0; j--)
                a *= 26;
            count += a;
        }
        return count;
    }
}