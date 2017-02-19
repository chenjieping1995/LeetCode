public class Solution {
    public String[] findWords(String[] words) {
        // 创建三个List，用来存放每一行的字母
        ArrayList<Integer> row1 = new ArrayList<>();
        ArrayList<Integer> row2 = new ArrayList<>();
        ArrayList<Integer> row3 = new ArrayList<>();
        // 初始化
        String r1 = "qwertyuiopQWERTYUIOP";
        String r2 = "asdfghjklASDFGHJKL";
        String r3 = "zxcvbnmZXCVBNM";
        // 初始化每一行的字母List
        for(int i=0, n=r1.length(); i<n; i++){
            row1.add(r1.codePointAt(i));
        }
        for(int i=0, n=r2.length(); i<n; i++){
            row2.add(r2.codePointAt(i));
        }
        for(int i=0, n=r3.length(); i<n; i++){
            row3.add(r3.codePointAt(i));
        }
        
        // 结果List
        ArrayList<String> result = new ArrayList<>();
        // 程序的核心运行部分
        for (String s : words){
            if (s.length() == 1)    result.add(s);
            else{
                if (row1.contains(s.codePointAt(0))){
                    for(int i=1, n=s.length(); i<n; i++){
                        if (!row1.contains(s.codePointAt(i)))    break;
                        if (i == n-1)   result.add(s);
                    }
                } else if (row2.contains(s.codePointAt(0))){
                    for(int i=1, n=s.length(); i<n; i++){
                        if (!row2.contains(s.codePointAt(i)))    break;
                        if (i == n-1)   result.add(s);
                    }
                } else if (row3.contains(s.codePointAt(0))){
                    for(int i=1, n=s.length(); i<n; i++){
                        if (!row3.contains(s.codePointAt(i)))    break;
                        if (i == n-1)   result.add(s);
                    }
                }
            }
        }
        // 将结果类转化为字符串型数组
        int size=result.size(); 
        String[] array = (String[])result.toArray(new String[size]); 
        // 返回结果
        return array;
    }
}