class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        int len = s.length();
        if (len<=0 || s==null) {
            return count;
        }
        for (int i=0; i<len; i++) {
            findPalindSubString(s, i, i);
            findPalindSubString(s, i, i+1);
        }
        return count;
    }
    
    public void findPalindSubString(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}