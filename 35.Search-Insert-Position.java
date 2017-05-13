public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        
        // corner case 
        if (len==0||nums==null) {
            return 0;
        }
        
        int left = 0;
        int right = len-1;
        
        // binary search loop, when loop end, there will be 2 elements between left and right index
        while (left<right-1) {
            int mid=(right+left)/2;
            if (target==nums[mid]) {
                return mid;
            } else if (target>nums[mid]) {
                left=mid;
            } else {
                right=mid;
            }
        }
        
        // find the insert index
        if (target<nums[left]) {
            return (left==0) ? 0 : (left-1);
        } else if (target==nums[left]) {
            return left;
        } else if (target>nums[left] && target<nums[right]) {
            return left+1;
        } else if (target==nums[right]) {
            return right;
        } else {
            return right+1;
        }
    }
}