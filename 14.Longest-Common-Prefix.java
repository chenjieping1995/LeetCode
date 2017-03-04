public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // 考虑一下边界情况
        if (strs == null || strs.length == 0)   return "";
        
        // 利用 Arrays 自带的 sort() 方法来对原来数组中的元素进行按字母序排序
        Arrays.sort(strs);
        
        // 再比较第一个和最后一个字符串, 求他们的最长公共前缀
        int strLen = strs[0].length();
        StringBuilder res = new StringBuilder();
        
        int index = strs.length - 1;
        
        for (int i=0; i<strLen; i++){
            if (strs[0].codePointAt(i) == strs[index].codePointAt(i)){
                res.append("" + strs[0].charAt(i));
                continue;
            }
            else break;
        }
        
        return res.toString();
    }
}