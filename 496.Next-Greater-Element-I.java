// 这是一种时间复杂度为 O(m+n)的解法，其中m、n分别为findNums和nums的数组长度
// 采用了递减栈的思路：遍历nums数组，当后一个元素比前一个元素小或者是空栈时，压栈；
// 					   当出现某一个元素num大于前面一个时，把所有栈内比它小的元素弹出；
//					   同时，这些弹出元素的next greater element标注为x，存入map；
//					   最后，遍历findNums，将所有元素的next greater element输出(或者为-1)。
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
		// 初始化 map 及 栈stack
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
		// 建立递减栈，遍历nums数组
        for (int num : nums){
			// 空栈或者是后元素大于前元素，弹出栈顶并标记
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
			// 否则压栈
            stack.push(num);
        }
		// 遍历findNums统计结果
        for (int i=0; i<findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        // 将结果输出
		return findNums;
    }
}