public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 可以采取先对集合内的元素排序
        // 再利用一个for循环: 由第一个元素开始向后遍历
        //   然后在选择另外两个数的时候, 采用两个指针, 一头一尾向中间走
        //     当发生3个数的和为0的情况时, 加到结果列表里
        //     遇到相同的结果需要跳过 继续向中间推进
        // 最后返回结果列表
        
        List<List<Integer>> res = new LinkedList<>();
        
        if (nums == null || nums.length <= 2)
            return res;
        
        // 对数组元素排序
        Arrays.sort(nums);
        // 取得数组长度, 即元素总个数
        int len = nums.length;
        // 从第一个元素开始, for循环遍历
        for (int i=0; i<len-2; i++){
            if (i==0 || (i>0 && nums[i]!=nums[i-1])) {
                int low=i+1, high=len-1, sum=0-nums[i];
                while (low<high) {
                    // 选择另外两个符合要求的数
                    if (nums[low]+nums[high] == sum) {
                        // 符合条件的加到结果列表中去
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // 跳过相同的答案
                        while (nums[low+1] == nums[low] && low+1<high) low++;
                        while (nums[high-1] == nums[high] && high-1>low) high--;
                        low++;
                        high--;
                    } else if (nums[low]+nums[high] < sum){
                        // 两数和太小, 小数增大
                        low++;
                    } else {
                        // 两数和太大, 大数减小
                        high--;
                    }
                }
            }
        }
        
        return res;
    }
}