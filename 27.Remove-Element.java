public class Solution {
    public int removeElement(int[] nums, int val) {
        
        Arrays.sort(nums);
        
        int count = 0;
        
        int len = nums.length;
        
        for (int i=0; i<len; i++) {
            if (nums[i] != val) nums[count++] = nums[i];
        }
        
        return count;
    }
}