public class Solution {
    public int maximumProduct(int[] nums) {
        
        Arrays.sort(nums);
        int len = nums.length;
        
        if (len==3)
            return nums[0]*nums[1]*nums[2];
        
        // all numbers are negative
        if (nums[len-1]<0)
            return nums[len-1]*nums[len-2]*nums[len-3];
        
        // all numbers are positive
        if (nums[0]>=0) 
            return nums[len-1]*nums[len-2]*nums[len-3];
        
        int res1 = nums[len-1]*nums[len-2]*nums[len-3];
        int res2 = nums[len-1]*nums[0]*nums[1];
        return Math.max(res1, res2);
    }
}