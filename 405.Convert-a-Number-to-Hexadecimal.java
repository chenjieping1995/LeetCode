public class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        do {
            int n = num & 0xf;
            n += n < 0xa ? '0' : 'a' - 10;
            sb.append((char)n);
        } while ((num >>>= 4) != 0); 
        return sb.reverse().toString();
    }
}