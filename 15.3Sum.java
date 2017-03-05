public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // ���Բ�ȡ�ȶԼ����ڵ�Ԫ������
        // ������һ��forѭ��: �ɵ�һ��Ԫ�ؿ�ʼ������
        //   Ȼ����ѡ��������������ʱ��, ��������ָ��, һͷһβ���м���
        //     ������3�����ĺ�Ϊ0�����ʱ, �ӵ�����б���
        //     ������ͬ�Ľ����Ҫ���� �������м��ƽ�
        // ��󷵻ؽ���б�
        
        List<List<Integer>> res = new LinkedList<>();
        
        if (nums == null || nums.length <= 2)
            return res;
        
        // ������Ԫ������
        Arrays.sort(nums);
        // ȡ�����鳤��, ��Ԫ���ܸ���
        int len = nums.length;
        // �ӵ�һ��Ԫ�ؿ�ʼ, forѭ������
        for (int i=0; i<len-2; i++){
            if (i==0 || (i>0 && nums[i]!=nums[i-1])) {
                int low=i+1, high=len-1, sum=0-nums[i];
                while (low<high) {
                    // ѡ��������������Ҫ�����
                    if (nums[low]+nums[high] == sum) {
                        // ���������ļӵ�����б���ȥ
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // ������ͬ�Ĵ�
                        while (nums[low+1] == nums[low] && low+1<high) low++;
                        while (nums[high-1] == nums[high] && high-1>low) high--;
                        low++;
                        high--;
                    } else if (nums[low]+nums[high] < sum){
                        // ������̫С, С������
                        low++;
                    } else {
                        // ������̫��, ������С
                        high--;
                    }
                }
            }
        }
        
        return res;
    }
}