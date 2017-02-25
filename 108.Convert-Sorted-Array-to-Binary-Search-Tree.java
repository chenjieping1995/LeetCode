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
        // 每次都采用二分法找二叉树的根,采用递归实现
        if (nums.length == 0)   return null;
        else if (nums.length == 1)  return new TreeNode(nums[0]);
        return findRoot(nums, 0, nums.length-1);
    }
    
    public TreeNode findRoot(int[]nums, int low, int high) {
        // 根据传入的部分数组建立平衡二叉树
        if (low > high) {
            return null;
        } else {
            // 找出low和high的二分点
            int mid = (low + high)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = findRoot(nums, low, mid-1);
            node.right = findRoot(nums, mid+1, high);
            return node;
        }
    }
}