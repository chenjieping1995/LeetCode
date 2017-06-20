public class Solution {
    public int findComplement(int num) {
        int x = ~0;
        while ((x & num)!=0){
            x <<= 1;
        }
        return (~x)&(~num);
    }
}