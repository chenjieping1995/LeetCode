public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 题目限制不能使用除法,且时间复杂度要为O(n)
        // 考虑用两次for循环.
        
        int len = nums.length;
        int[] result = new int[len];
        
        result[0] = 1;
        
        // 第一次对于每个num[i],在res[i]中把索引小于i的所有数相乘存入
        for (int i=1; i<len; i++){
            result[i] = result[i-1] * nums[i-1];
        }
        
        int right = 1;
        
        // 第二次对于每个num[i],在res[i]中把索引大于i的所有数相乘存入
        for (int i=len-2; i>=0; i--){
            right *= nums[i+1];
            result[i] = result[i] * right;
        }
        return result;
    }
}