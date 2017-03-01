public class Solution {
    public String convert(String s, int numRows) {
        /**
         * ����ά��һ��numRows��С��StringBuilder����
         * ���ΰ�����-�ϵ�˳���ÿһ���ַ�����Ӻ�׺, ֱ���ﵽ�ַ����ĳ���Ϊֹ
         * ���, �������ַ���ƴ����һ��.toString(), ������
         */
         
         int len = s.length();
         if (len <= numRows || numRows == 1)    return s;
         if (numRows == 2) {
             StringBuilder two = new StringBuilder();
             for (int i=0; i<(len+1)/2; i++){
                 two.append(s.charAt(2*i));
             }
             for (int i=0; i<len/2; i++){
                 two.append(s.charAt(2*i+1));
             }
             return two.toString();
         }
         
         StringBuilder[] sb = new StringBuilder[numRows];
         for (int i=0; i<numRows; i++){
             sb[i] = new StringBuilder();
         }
         
         int index = 0;
         
         while (true) {
             // ����
             for (int i=0; i<numRows && index<len; i++){
                 sb[i].append(s.charAt(index));
                 index++;
             }
             // ����
             for (int i=numRows-2; i>0 && index<len; i--){
                 sb[i].append(s.charAt(index));
                 index++;
             }
             if (index == len)  break;
         }
         
         for (int i=1; i<numRows; i++){
             sb[0].append(sb[i]);
         }
         return sb[0].toString();
    }
}