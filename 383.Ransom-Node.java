public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int len1, len2;
        len1 = ransomNote.length();
        len2 = magazine.length();
        int count[] = new int[26];
        for (int i=0; i<26; i++)    count[i] = 0;
        for (int i=0; i<len2; i++){
            char x = magazine.charAt(i);
            int a;
            a = x - 'a';
            count[a]++;
        }
        for (int i=0; i<len1; i++){
            char x = ransomNote.charAt(i);
            int a;
            a = x - 'a';
            count[a]--;
        }
        for (int i=0; i<26; i++){
            if (count[i] < 0)   return false;
        }
        return true;
    }
}