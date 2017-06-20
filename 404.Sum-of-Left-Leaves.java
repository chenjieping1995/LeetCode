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
    public int sumOfLeftLeaves(TreeNode root) {
        if ((root == null) || ((root.left == null) && (root.right == null)))    return 0;
        else return recursion(root);
    }
    public int recursion(TreeNode root){
        int count = 0;
        if ((root.left == null) && (root.right == null))    return root.val;
        else {
            if (root.left != null)  count += recursion(root.left);
            if ((root.right != null) && ((root.right.left != null) || (root.right.right != null)))
                count += recursion(root.right);
        }
        return count;
    }
}