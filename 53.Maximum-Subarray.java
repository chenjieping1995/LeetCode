public class Solution {
    public int maxSubArray(int[] nums) {
        // ����ĳ���
        int len = nums.length;
        
        // �㷨����ԭ����,���÷��η����
        return findMaxSubArray(nums, 0, len-1);
    }
    
    public int findMaxSubArray(int[] nums, int low, int high){
        // �ݹ�Ѱ�����������,���������� �������� �����������з�������
        
        if (low == high)
            //�������
            return nums[low];
        
        int leftMax;
        int crossMax;
        int rightMax;
        
        // �ֱ�������������� ������� ���������е��������ֵ
        int mid = (low + high) / 2;
        leftMax = findMaxSubArray(nums, low, mid);
        rightMax = findMaxSubArray(nums, mid+1, high);
        crossMax = findCrossMax(nums, low, mid, high);
        
        // ȡ�������ֵ�е����ֵ
        if ((leftMax>=rightMax) && (leftMax>=crossMax)) 
            return leftMax;
        else if ((leftMax<=rightMax) && (rightMax>=crossMax))
            return rightMax;
        else return crossMax;
    }
    
    public int findCrossMax(int[] nums, int low, int mid, int high){
        // Ѱ�����Ŀ������ֵ
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int leftSum = 0;
        int rightSum = 0;
        
        for (int i=mid; i>=0; i--){
            // ����ߵ���������
            leftSum += nums[i];
            if (leftSum > leftMax)  leftMax = leftSum;
        }
        
        for (int i=mid+1; i<=high; i++){
            // ���ұߵ���������
            rightSum += nums[i];
            if (rightSum > rightMax)  rightMax = rightSum;
        }
        
        // �������ߵ���������
        return (leftMax + rightMax);
    }
}