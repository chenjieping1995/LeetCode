public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int len = nums.length;
        for (int i=0; i<len; i++){
            if (set.contains(nums[i]) == true)  return true;
            else set.add(nums[i]);
        }
        return false;
    }
}
