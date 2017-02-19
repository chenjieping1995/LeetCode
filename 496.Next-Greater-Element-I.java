// ����һ��ʱ�临�Ӷ�Ϊ O(m+n)�Ľⷨ������m��n�ֱ�ΪfindNums��nums�����鳤��
// �����˵ݼ�ջ��˼·������nums���飬����һ��Ԫ�ر�ǰһ��Ԫ��С�����ǿ�ջʱ��ѹջ��
// 					   ������ĳһ��Ԫ��num����ǰ��һ��ʱ��������ջ�ڱ���С��Ԫ�ص�����
//					   ͬʱ����Щ����Ԫ�ص�next greater element��עΪx������map��
//					   ��󣬱���findNums��������Ԫ�ص�next greater element���(����Ϊ-1)��
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
		// ��ʼ�� map �� ջstack
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
		// �����ݼ�ջ������nums����
        for (int num : nums){
			// ��ջ�����Ǻ�Ԫ�ش���ǰԪ�أ�����ջ�������
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
			// ����ѹջ
            stack.push(num);
        }
		// ����findNumsͳ�ƽ��
        for (int i=0; i<findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        // ��������
		return findNums;
    }
}