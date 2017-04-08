public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int len = nums.length;
        
        // sort the array
        Arrays.sort(nums);
        
        int closet = Integer.MAX_VALUE;
        int res=0;
        // traverse the array, choose one element, and the other two use the two pointers method
        for (int i=0; i<len-2; i++){
            int start = i+1;
            int end = len-1;
            while (start<end) {
                int sum = nums[start]+nums[end]+nums[i];
                int diff = Math.abs(sum-target);
                if(closet>diff) {
                    closet = diff;
                    res = sum;
                }
                if (sum > target) {
                    // the sum is too large
                    end--;
                } else if (sum < target) {
                    // the sum is too small
                    start++;
                } else {
                    return sum;
                }
            }
        }
        
        return res;
    }
}