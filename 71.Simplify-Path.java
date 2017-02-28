public class Solution {
    public String simplifyPath(String path) {
        // ����ջ������
        // ����һ����ջ, ��ָ���ĺ����ַ���(".","")
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList(".","",".."));
        
        // ��"/"Ϊ�зֱ�׼��������path
        // ����ÿһ���зֳ������ַ���, �����ж�ʶ��
        for (String str : path.split("/")) {
            //  ���Ϊ".."����ջ�ڷǿյĻ�, ����һ��Ԫ��
            if (str.equals("..") && stack.size() != 0)   stack.pop();
            //  ������ں����ַ�����, �Ѹ��ַ���ѹ��ջ
            if (!skip.contains(str))    stack.push(str);
        }
        
        // ����һ��·���ַ���, ÿ�ζ���/ + ������Ԫ�طŵ��ַ�������ǰ
        StringBuilder res = new StringBuilder();
        while (stack.size() != 0) {
            // ����Ҫȡstack��βԪ�أ�
            res.append("/"+stack.pollLast());
        }
        return (res.length()==0) ? "/" : res.toString();
    }
}