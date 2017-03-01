public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // ��Ϊ���Ӵ��в������ظ����ַ�
        // ���Ա�ѡ������Ӵ���Ȼ���� ..a..b..a..b..
        // ��������� ..a..b..b..a.. ��b..bΪ���ϵĴ�
        // ������������ָ��, ��ָ����ǰ, �������ظ��ַ�ʱ, ��ָ��ָ��ǰ��ͬһ�ַ�
        // 
        
        int len = s.length();
        if (len == 0)   return 0;
        int max = 0;
        
        // �����洢��ǰ�Լ����ֵ��ַ������Ե���Ϣ
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0, j=0; i<len; i++){
            if (map.containsKey(s.charAt(i))){
                // �����1���Ա�֤���ַ��Ĵ�������ȷ���
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        
        return max;
    }
}