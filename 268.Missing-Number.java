public class Solution {
    public int missingNumber(int[] nums) {
        // �������������Ƶ��㷨��
		// ����������� a ^ b ^ b = a
        int result=0, i=0;
        
        for (int n=nums.length; i<n; i++){
            result = result ^ i ^ nums[i];
        }
        
        return result ^ i;
    }
}