public class Solution {
    public String simplifyPath(String path) {
        // 利用栈来解题
        // 创建一个空栈, 和指定的忽略字符集(".","")
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList(".","",".."));
        
        // 以"/"为切分标准线来划分path
        // 对于每一个切分出来的字符串, 进行判断识别
        for (String str : path.split("/")) {
            //  如果为".."并且栈内非空的话, 弹出一个元素
            if (str.equals("..") && stack.size() != 0)   stack.pop();
            //  如果不在忽略字符集中, 把该字符串压入栈
            if (!skip.contains(str))    stack.push(str);
        }
        
        // 创建一个路径字符串, 每次都将/ + 弹出的元素放到字符串的最前
        StringBuilder res = new StringBuilder();
        while (stack.size() != 0) {
            // 这里要取stack的尾元素？
            res.append("/"+stack.pollLast());
        }
        return (res.length()==0) ? "/" : res.toString();
    }
}