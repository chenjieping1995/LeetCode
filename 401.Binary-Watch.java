public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<String>();
        if (num < 0)   return list;
        for (int h=0; h<12; h++){
            for (int m=0; m<60; m++){
                if (Integer.bitCount(h) + Integer.bitCount(m) == num){
                    list.add(String.format("%d:%02d",h,m));
                }
            }
        }
        return list;
    }
}