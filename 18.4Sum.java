public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int len = nums.length;
        
        // ����Ԫ�ز���4��, ֱ�ӷ��ؿռ���
        if (len < 4)    return res;
        if (len==4 && nums[0]+nums[1]+nums[2]+nums[3]==target){
            res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return res;
        }

        
        Arrays.sort(nums);
        
        int max = nums[len-1];
        if (max * 4 < target || 4 * nums[0] > target)
            // ����Ԫ�ز���target/4������, ֱ�ӷ��ؿռ���
            return res;
        
        for (int i=0; i<len-3; i++){
            // �����ظ�
            if (i>0 && nums[i]==nums[i-1])
                continue;
                
            int sum = target - nums[i];
            threeSum(nums, sum, res, i+1, len, nums[i]);
        }
        
        return res;
    }
    
    public void threeSum(int[] nums, int target, List<List<Integer>> res, int start, int len, int x1){
        /** 
         * ����Ĳ����ֱ�Ϊ
         * nums ��������, target ��������Ŀ���
         * res �������, start ����ɨ������
         * len �����ܳ���, x1 ���ĸ�Ԫ��
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