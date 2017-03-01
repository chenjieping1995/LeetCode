public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 结果数组, 表示是两个整数索引
        int[] res = new int [2];
        
        // 建立一个hashmap键值对集合
        Map<Integer, Integer> map = new HashMap<>();
        
        // 每一次都把数组中的元素作为键存入, 值对应着其索引
        // 如果map中存在键等于(target-当前的元素值), 存入两次的索引并返回
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(target-nums[i])) {
                res[1] = i;
                res[0] = map.get(target-nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        
        return res;
    }
}