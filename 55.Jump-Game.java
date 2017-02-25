public class Solution {
    public boolean canJump(int[] nums) {
        // 取一个变量为当前所能到大的最远位置,如果某一位不可达则退出
        int reachable = 0;
        int len = nums.length;
        for (int i=0; i<len; i++){
            if (i > reachable)  return false;
            reachable = Math.max(reachable, i+nums[i]);
        }
        return true;
    }
}