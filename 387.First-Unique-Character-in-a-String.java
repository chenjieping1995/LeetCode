public class Solution {
    public int firstUniqChar(String s) {
        int c[] = new int[26];
        int len = s.length();
        for (int i=0; i<len; i++){
            char a = s.charAt(i);
            int x = a - 'a';
            c[x]++;
        }
        for (int i=0; i<len; i++){
            char a = s.charAt(i);
            int x = a - 'a';
            if (c[x] == 1)  return i;
        }
        return -1;
    }
}