public class Solution {
    public boolean checkRecord(String s) {
        
        int len = s.length();
        // corner case
        if (len<=1)
            return true;
        
        char[] arr = s.toCharArray();
        int numA = 0;
        int continuousL = 0;
        
        for (int i=0; i<len; i++) {
            if (arr[i]=='L') {
                continuousL++;
            } else if (arr[i]=='A') {
                numA++;
                continuousL=0;
            } else {
                continuousL=0;
            }
            
            if (numA>1 || continuousL>2) 
                return false;
        }
        
        return true;
    }
}