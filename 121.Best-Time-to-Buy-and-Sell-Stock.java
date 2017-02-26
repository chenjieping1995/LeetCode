public class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        if (len == 0)   return 0;
        
        int max = 0;
        int soFarMin = prices[0];
        
        for (int i=1; i<len; i++){
            // 
            if (prices[i] > soFarMin){
                max = Math.max(max, prices[i]-soFarMin);
            } else {
                soFarMin = prices[i];
            }
        }
        
        return max;
    }
}