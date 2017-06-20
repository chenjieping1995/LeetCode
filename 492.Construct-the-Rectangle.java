public class Solution {
    public int[] constructRectangle(int area) {
        int l = (int)Math.sqrt(area);
        int w = l;
        while((l*w) != area){
            if (l*w < area)
                l += 1;
            else if(l*w > area)
                w -= 1;
        }
        int[] result = new int[2];
        result[0] = l;
        result[1] = w;
        return result;
    }
}