public class Solution {
    public int divide(int dividend, int divisor) {
        // corner case 
        if (divisor==0)
            return dividend>=0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        // overflow case
        if (dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        else if (dividend==Integer.MAX_VALUE && divisor==1)
            return Integer.MAX_VALUE;
        else if (dividend==Integer.MAX_VALUE && divisor==-1)
            return Integer.MIN_VALUE;
        else if (dividend==Integer.MIN_VALUE && divisor==1)
            return Integer.MIN_VALUE;
        
        int res=0;
        // 
        boolean isNeg = false;
        if ((dividend<0 && divisor>0)||(dividend>0 && divisor<0))
            isNeg = true;
        
        // 
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        while (true) {
            long a = findNum(ldividend, ldivisor);
            if (a==-1) {
                if (isNeg)  return 0-res;
                else return res;
            }
            res += 1<<a;
            ldividend -= ldivisor<<a;
        }
    }
    
    // return the positive number a, make that x*2^a <= y < x*2^(a+1)
    public long findNum(long y, long x) {
        if (x>y)    return -1;
        int a=0;
        while ((x<<(a+1)) <= y){
            a++;
        }
        return a;
    }
}