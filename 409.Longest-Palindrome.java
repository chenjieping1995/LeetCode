public class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1)   return len;
        int count[] = new int [52];
        
        for (int i=0; i<len; i++){
            char x = s.charAt(i);
            int a = judgeChar(x);
            count[a]++;
        }
        
        int result = 0;
        boolean flag = false;
        for (int i=0; i<52; i++){
            if (count[i] % 2 == 0)  result = result + count[i];
            else {
                result = result + count[i] - 1;
                flag = true;
            }
        }
        if (flag == true)   result++;
        
        return result;
    }
    public int judgeChar(char x){
        int result = 0;
        if ((x >= 'a') && (x <= 'z'))
            result = x - 'a';
        else if ((x >= 'A') && (x <= 'Z'))
            result = x - 'A' + 26;
        return result;
    }
}