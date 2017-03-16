public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1)   return len;
        
        int now = nums[0];
        int count = len;
        List<Integer> result = new ArrayList<Integer>();
        result.add(nums[0]);
        
        for (int i=1; i<len; i++) {
            if (now == nums[i]) {
                count--;
                continue;
            } else {
                now = nums[i];
                result.add(now);
                continue;
            }
        }
        
        for (int i=0; i<count; i++) {
            nums[i] = result.get(i);
        }
        
        return count;
    }
}