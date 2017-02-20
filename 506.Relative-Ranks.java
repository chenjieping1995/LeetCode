public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        
		int len = nums.length;
        
		// 声明结果数组 和 存储排序情况的字典 map
        String[] result = new String[len];
        Map<Integer, String> map = new HashMap<>();
        
		// 复制给定的数组 nums
        int[] nums_copy = new int[len];
        for (int i=0; i<len; i++){
            nums_copy[i] = nums[i];
        }
        
		// 利用 Java 自带的数组排序功能排序
        Arrays.sort(nums_copy);
        
		// 向字典中存入排序结果
        for (int i=len-1; i>=0; i--){
            String s;
            int k = len-i;
            switch(k){
                case 1:
                    s = "Gold Medal";
                    break;
                case 2:
                    s = "Silver Medal";
                    break;
                case 3:
                    s = "Bronze Medal";
                    break;
                default:
                    s = String.valueOf(k);
                    break;
            }
            map.put(nums_copy[i], s);
        }
        
		// 根据数组 nums 的内容，从字典中将结果导入到结果数组
        for (int i=0; i<len; i++){
            result[i] = map.get(nums[i]);
        }
        
        return result;
    }
}