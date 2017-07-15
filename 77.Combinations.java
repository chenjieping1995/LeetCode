public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        if (n<k)    return null;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        backtrace(result, new ArrayList<Integer>(), n, k, 1);
        
        return result;
    }
    
    // backtrace
    public void backtrace(List<List<Integer>> result, List<Integer> object, int n, int k, int i) {
        
        if (k==0) {
            result.add(new ArrayList<Integer>(object));
            return;
        }
        
        for (int j=i; j<=n; j++) {
            object.add(j);
            backtrace(result, object, n, k-1, j+1);
            object.remove(object.size()-1);
        }
    }
}