public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        
		int len = nums.length;
        
		// ����������� �� �洢����������ֵ� map
        String[] result = new String[len];
        Map<Integer, String> map = new HashMap<>();
        
		// ���Ƹ��������� nums
        int[] nums_copy = new int[len];
        for (int i=0; i<len; i++){
            nums_copy[i] = nums[i];
        }
        
		// ���� Java �Դ�����������������
        Arrays.sort(nums_copy);
        
		// ���ֵ��д���������
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
        
		// �������� nums �����ݣ����ֵ��н�������뵽�������
        for (int i=0; i<len; i++){
            result[i] = map.get(nums[i]);
        }
        
        return result;
    }
}