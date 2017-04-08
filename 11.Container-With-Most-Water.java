public class Solution {
    /**
     * O(n)�ĸ��Ӷȡ���������ָ��i,j���ֱ�ָ�򳤶��������β�����ai С��aj�����ƶ�i���i++����
     * ��֮���ƶ�j��ǰ(j--���������ǰ��area����������¼��area���滻֮��
     * ����뷨�Ļ����ǣ����i�ĳ���С��j����������ƶ�j���̰���i���������ҵ��ȵ�ǰ��¼��area�����ֵ�ˣ�
     * ֻ��ͨ���ƶ�i���ҵ��µĿ��ܵĸ��������
     */
    public int maxArea(int[] height) {
        
        int len = height.length;
        
        // corner case
        if (len==2) return Math.min(height[0], height[1]);
        
        // two pointers
        int start = 0;
        int end = len-1;
        int maxContainer = 0;
        
        while (start<end){
            int container = Math.min(height[start], height[end]) * (end-start);
            if (container>=maxContainer)
                maxContainer = container;
            if (height[start]<=height[end]){
                start++;
            } else {
                end--;
            }
        }
        
        return maxContainer;
    }
}