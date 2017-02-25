/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // ÿ�ζ����ö��ַ��Ҷ������ĸ�,���õݹ�ʵ��
        if (nums.length == 0)   return null;
        else if (nums.length == 1)  return new TreeNode(nums[0]);
        return findRoot(nums, 0, nums.length-1);
    }
    
    public TreeNode findRoot(int[]nums, int low, int high) {
        // ���ݴ���Ĳ������齨��ƽ�������
        if (low > high) {
            return null;
        } else {
            // �ҳ�low��high�Ķ��ֵ�
            int mid = (low + high)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = findRoot(nums, low, mid-1);
            node.right = findRoot(nums, mid+1, high);
            return node;
        }
    }
}