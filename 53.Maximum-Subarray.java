public class Solution {
    public int maxSubArray(int[] nums) {
        // 数组的长度
        int len = nums.length;
        
        // 算法导论原例题,采用分治法求解
        return findMaxSubArray(nums, 0, len-1);
    }
    
    public int findMaxSubArray(int[] nums, int low, int high){
        // 递归寻找最大子数组,在左子数组 右子数组 跨区间数组中返回最大的
        
        if (low == high)
            //基本情况
            return nums[low];
        
        int leftMax;
        int crossMax;
        int rightMax;
        
        // 分别求出在左子数组 跨界数组 右子数组中的最大区间值
        int mid = (low + high) / 2;
        leftMax = findMaxSubArray(nums, low, mid);
        rightMax = findMaxSubArray(nums, mid+1, high);
        crossMax = findCrossMax(nums, low, mid, high);
        
        // 取三个最大值中的最大值
        if ((leftMax>=rightMax) && (leftMax>=crossMax)) 
            return leftMax;
        else if ((leftMax<=rightMax) && (rightMax>=crossMax))
            return rightMax;
        else return crossMax;
    }
    
    public int findCrossMax(int[] nums, int low, int mid, int high){
        // 寻找最大的跨界区间值
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int leftSum = 0;
        int rightSum = 0;
        
        for (int i=mid; i>=0; i--){
            // 求左边的最大区间和
            leftSum += nums[i];
            if (leftSum > leftMax)  leftMax = leftSum;
        }
        
        for (int i=mid+1; i<=high; i++){
            // 求右边的最大区间和
            rightSum += nums[i];
            if (rightSum > rightMax)  rightMax = rightSum;
        }
        
        // 返回两边的最大区间和
        return (leftMax + rightMax);
    }
}