public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // ����һ�±߽����
        if (strs == null || strs.length == 0)   return "";
        
        // ���� Arrays �Դ��� sort() ��������ԭ�������е�Ԫ�ؽ��а���ĸ������
        Arrays.sort(strs);
        
        // �ٱȽϵ�һ�������һ���ַ���, �����ǵ������ǰ׺
        int strLen = strs[0].length();
        StringBuilder res = new StringBuilder();
        
        int index = strs.length - 1;
        
        for (int i=0; i<strLen; i++){
            if (strs[0].codePointAt(i) == strs[index].codePointAt(i)){
                res.append("" + strs[0].charAt(i));
                continue;
            }
            else break;
        }
        
        return res.toString();
    }
}