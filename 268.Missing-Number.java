public class Solution {
    public int missingNumber(int[] nums) {
        // 基于异或运算设计的算法。
		// 异或运算满足 a ^ b ^ b = a
        int result=0, i=0;
        
        for (int n=nums.length; i<n; i++){
            result = result ^ i ^ nums[i];
        }
        
        return result ^ i;
    }
}