public class Solution {
    public String convertToBase7(int num) {
        String result = "";
        
        while (num / 7 != 0){
            int num1 = num % 7;
            result = String.valueOf(Math.abs(num1)).concat(result);
            num = (num - num1) / 7;
        }
        result = String.valueOf(num).concat(result);
        
        return result ;
    }
}