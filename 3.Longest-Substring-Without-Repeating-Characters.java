public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 因为在子串中不存在重复的字符
        // 所以备选的最大子串必然符合 ..a..b..a..b..
        // 而如果遇到 ..a..b..b..a.. 则b..b为符合的串
        // 可以设置两个指针, 右指针向前, 当发现重复字符时, 左指针指向前面同一字符
        // 
        
        int len = s.length();
        if (len == 0)   return 0;
        int max = 0;
        
        // 用来存储当前以及发现的字符索引对的信息
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0, j=0; i<len; i++){
            if (map.containsKey(s.charAt(i))){
                // 这里加1可以保证单字符的串返回正确结果
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        
        return max;
    }
}