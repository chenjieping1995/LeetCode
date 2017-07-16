public class Solution {
    public String minWindow(String s, String t) {
        // corner case
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen || sLen==0 || tLen==0) {
            return "";
        }
        
        // initialize the hashmap for each character in target string
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<tLen; i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i))+1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int start = 0;
        int count = 0;
        
        // the time complexity is O(n)
        for (int right=0; right<sLen; right++) {
            if (map.containsKey(s.charAt(right))) {
                // change the value in hashmap
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                if (map.get(s.charAt(right))>=0) {
                    // the character is valid
                    count++;
                }
                while (count==tLen) {
                    // the target string 
                    if (right-left+1<minLen) {
                        minLen = right-left+1;
                        start = left;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left))+1);
                        if (map.get(s.charAt(left))>0) {
                            // the left character is used in target string
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        
        if (minLen==Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start+minLen);
    }
}