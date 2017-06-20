public class Solution {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 != len2)   return false;
        int count[] = new int [26];
        for (int i=0; i<26; i++)
            count[i] = 0;
        for (int i=0; i<len1; i++){
            // ±éÀús
            char x = s.charAt(i);
            count[x-'a']++;
        }
        for (int i=0; i<len2; i++){
            // ±éÀút
            char x = t.charAt(i);
            count[x-'a']--;
        }
        for (int i:count)
            if (i != 0)  return false;
        return true;
    }
}