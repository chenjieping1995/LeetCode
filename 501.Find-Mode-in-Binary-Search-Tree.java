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
    
    Map<Integer, Integer> freqs = new HashMap<>();
    List<Integer> nums = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    
    public int[] findMode(TreeNode root) {
        // 中序遍历树, 把树结点的值按次序加入到map中

        inorder(root);
        
        int len = nums.size();
        int maxFreq = 0;
        
        for (int i=0; i<len; i++){
            // 取得此关键值出现的频率
            int freq = freqs.get(nums.get(i));
            if (freq > maxFreq){
                // 此频率当前为最大
                maxFreq = freq;
                result.clear();
                result.add(nums.get(i));
            } else if (freq == maxFreq) {
                result.add(nums.get(i));
            } else  continue;
        }
        
        int[] res = new int[result.size()];
        for (int i=0; i<result.size(); i++){
            res[i] = result.get(i);
        }
        
        return res;
    }
    
    public void inorder(TreeNode root) {
        if (root == null)   return ;
        inorder(root.left);
        freqs.put(root.val, freqs.getOrDefault(root.val, 0)+1);
        if ( !nums.contains(root.val) ) nums.add(root.val);
        inorder(root.right);
    }
}