public class Solution {
    public String reverseStr(String s, int k) {
        
        int len = s.length();
        // corner case
        if (len<=1 || k<=1)
            return s;
        char[] arr = s.toCharArray();
        
        int start = 0;
        while (start+k < len) {
            // reverse characters
            reverseCharArr(arr, start, start+k-1);
            start += 2*k;
        }
        // less than k characters left, reverse all of them
        if (len>start)
            reverseCharArr(arr, start, len-1);
        
        return String.valueOf(arr);
    }
    
    // reverse char array from index i to j
    public void reverseCharArr(char[] arr, int m, int n) {
        int l = m+(n-m)/2;
        for (int i=m; i<=l; i++) {
            char temp = arr[i];
            arr[i] = arr[m+n-i];
            arr[m+n-i] = temp;
        }
    }
}