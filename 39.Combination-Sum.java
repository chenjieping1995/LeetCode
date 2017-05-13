public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort the candidates
        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (candidates==null || candidates.length==0){
            return res;
        }
        
        // backtracking
        backtrace(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void backtrace(int[] candidates, int start, int target, List<Integer> elem, List<List<Integer>> res) {
        // loop end condition
        if (target == 0) {
            res.add(elem);
            return;
        }
        for (int i=start; i<candidates.length; i++) {
            int newTarget = target-candidates[i];
            if (newTarget >= 0){
                List<Integer> copy = new ArrayList<Integer>(elem);
                copy.add(candidates[i]);
                backtrace(candidates, i, newTarget, copy, res);
            } else {
                return;
            }
        }
        return;
    }
}