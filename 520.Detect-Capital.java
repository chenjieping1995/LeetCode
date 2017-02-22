public class Solution {
    public boolean detectCapitalUse(String word) {
        boolean result = true;
        int len = word.length();
        
        if (len == 1) return result;
        else {
            if (Character.isLowerCase(word.codePointAt(0))){
                // ����ĸΪСд
                for (int i=1; i<len; i++){
                    if (Character.isUpperCase(word.codePointAt(i)))
                        return false;
                }
            } else {
                // ����ĸΪ��д
                if (Character.isLowerCase(word.codePointAt(1))){
                    // �ڶ�����ĸΪСд
                    for (int i=2; i<len; i++){
                        if (Character.isUpperCase(word.codePointAt(i)))
                            return false;
                    }
                } else {
                    // �ڶ�����ĸΪ��д
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