public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int[] res = {-1, -1};
        
        // corner case
        if (len==0||nums==null) {
            return res;
        }
        
        // binary search loop, when loop end, there will be 2 elements between left and right index
        while (left<right-1) {
            // search the left bound
            int mid = (right+left)/2;
            if(nums[mid] == target){
                right = mid;
            } else if(nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        // set the left bound
        if (nums[left]==target) {
            res[0]=left;
        } else if (nums[right]==target) {
            res[0]=right;
        } else {
            return res;
        }
        
        // reset the left and right index
        left=0;
        right=len-1;
        
        // search the right bound
        while (left<right-1) {
            int mid=(right+left)/2;
            if (nums[mid]==target) {
                left=mid;
            } else if (nums[mid] < target) {
                left=mid;
            } else {
                right = mid;
            }
        }
        
        // set the right bound
        if (nums[right]==target) {
            res[1]=right;
        } else if (nums[left]==target) {
            res[1]=left;
        } else {
            return res;
        }
        
        return res;
    }
}