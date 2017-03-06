public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int len = nums.length;
        
        // 数组元素不足4个, 直接返回空集合
        if (len < 4)    return res;
        if (len==4 && nums[0]+nums[1]+nums[2]+nums[3]==target){
            res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return res;
        }

        
        Arrays.sort(nums);
        
        int max = nums[len-1];
        if (max * 4 < target || 4 * nums[0] > target)
            // 数组元素不在target/4区域内, 直接返回空集合
            return res;
        
        for (int i=0; i<len-3; i++){
            // 避免重复
            if (i>0 && nums[i]==nums[i-1])
                continue;
                
            int sum = target - nums[i];
            threeSum(nums, sum, res, i+1, len, nums[i]);
        }
        
        return res;
    }
    
    public void threeSum(int[] nums, int target, List<List<Integer>> res, int start, int len, int x1){
        /** 
         * 传入的参数分别为
         * nums 给定数组, target 三个数的目标和
         * res 结果集合, start 本次扫描的起点
         * len 数组总长度, x1 第四个元素
         */
         
         for (int i=start; i<len-2; i++){
            if (i>start && nums[i]==nums[i-1])
                continue;
                
            int low=i+1, high=len-1, sum=target-nums[i];
            while (low < high) {
                if (nums[low]+nums[high] == sum){
                    res.add(Arrays.asList(x1, nums[i], nums[low], nums[high]));
                    while (nums[low]==nums[low+1] && low+1<high)    low++;
                    while (nums[high]==nums[high-1] && low<high-1)  high--;
                    low++;
                    high--;
                } else if (nums[low]+nums[high] > sum) {
                    high--;
                } else {
                    low++;
                }
            }
         }
         
         return ;
    }
}