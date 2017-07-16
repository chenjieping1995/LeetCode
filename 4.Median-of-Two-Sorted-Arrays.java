public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        
        if (m>n) 
            return binSearch(nums2, nums1, n, m);
        else 
            return binSearch(nums1, nums2, m, n);
    }
    
    public double binSearch(int[] a, int[] b, int m, int n) {
        
        int left = 0, right = m, halfLen = (m+n+1)/2;
        int maxLeft=0, minRight=0;
        
        // binary search
        while (left<=right) {
            int i = (left+right)/2;
            int j = halfLen - i;
               
            if (i>0 && a[i-1]>b[j]) {
                // the value of i is too large
                right = i-1;
            } else if (i<m && a[i]<b[j-1]) {
                // the value of i is too small
                left = i+1;
            } else {
                if (i==0) 
                    maxLeft = b[j-1];
                else if (j==0)
                    maxLeft = a[i-1];
                else
                    maxLeft = Math.max(a[i-1], b[j-1]);
                
                if ((m+n)%2 == 1)
                    return maxLeft;
                
                if (i==m)
                    minRight = b[j];
                else if (j==n) 
                    minRight = a[i];
                else minRight = Math.min(a[i], b[j]);
                
                break;
            }
        }
        
        return (maxLeft+minRight)/(2.0);
    }
}