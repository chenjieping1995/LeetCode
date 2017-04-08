public class Solution {
    public String longestPalindrome(String s) {
        // dynamic programming
        
        int len = s.length();
        // corner case
        if (len<=1) return s;
        
        boolean[][] dp = new boolean[len][len];
        
        // dp[i][j] == true only when s[i]...s[j] is a palindromic string
        
        // initialization
        for (int i=0; i<len; i++){
            dp[i][i]=true;
        }
        
        for (int i=0; i<len-1; i++){
            if (s.charAt(i)==s.charAt(i+1))
                dp[i][i+1]=true;
        }
        
        // complete the dynamic programming
        for (int i=2; i<len; i++){
            // i indicates the difference between the start and the end index
            for (int j=0; j<len-i; j++){
                // j indicates the start index
                if (dp[j+1][i+j-1]==true && s.charAt(j)==s.charAt(i+j))
                    dp[j][i+j]=true;
            }
        }
        
        // find the longest palindromic substring from the two-dimensional array
        for (int i=len-1; i>=0; i--){
            // i indicates the difference between the start and end index
            for (int j=0; j<len-i; j++){
                // j indicates the start index
                if (dp[j][j+i]==true)
                    return s.substring(j, j+i+1);
            }
        }
        return "";
    }
}