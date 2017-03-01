public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // �������, ��ʾ��������������
        int[] res = new int [2];
        
        // ����һ��hashmap��ֵ�Լ���
        Map<Integer, Integer> map = new HashMap<>();
        
        // ÿһ�ζ��������е�Ԫ����Ϊ������, ֵ��Ӧ��������
        // ���map�д��ڼ�����(target-��ǰ��Ԫ��ֵ), �������ε�����������
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