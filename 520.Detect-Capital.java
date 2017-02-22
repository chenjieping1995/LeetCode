public class Solution {
    public boolean detectCapitalUse(String word) {
        boolean result = true;
        int len = word.length();
        
        if (len == 1) return result;
        else {
            if (Character.isLowerCase(word.codePointAt(0))){
                // 首字母为小写
                for (int i=1; i<len; i++){
                    if (Character.isUpperCase(word.codePointAt(i)))
                        return false;
                }
            } else {
                // 首字母为大写
                if (Character.isLowerCase(word.codePointAt(1))){
                    // 第二个字母为小写
                    for (int i=2; i<len; i++){
                        if (Character.isUpperCase(word.codePointAt(i)))
                            return false;
                    }
                } else {
                    // 第二个字母为大写
                    for (int i=2; i<len; i++){
                        if (Character.isLowerCase(word.codePointAt(i)))
                            return false;
                    }
                }
            }
        }
        
        return result;
    }
}