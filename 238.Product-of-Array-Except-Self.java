public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // ��Ŀ���Ʋ���ʹ�ó���,��ʱ�临�Ӷ�ҪΪO(n)
        // ����������forѭ��.
        
        int len = nums.length;
        int[] result = new int[len];
        
        result[0] = 1;
        
        // ��һ�ζ���ÿ��num[i],��res[i]�а�����С��i����������˴���
        for (int i=1; i<len; i++){
            result[i] = result[i-1] * nums[i-1];
        }
        
        int right = 1;
        
        // �ڶ��ζ���ÿ��num[i],��res[i]�а���������i����������˴���
        for (int i=len-2; i>=0; i--){
            right *= nums[i+1];
            result[i] = result[i] * right;
        }
        return result;
    }
}