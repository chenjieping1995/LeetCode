public class Solution {     
    
        List<List<String>> stringsArray = new ArrayList<List<String>>();
        List<String> str2 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<String> str3 = new ArrayList<>(Arrays.asList("d", "e", "f"));
        List<String> str4 = new ArrayList<>(Arrays.asList("g", "h", "i"));
        List<String> str5 = new ArrayList<>(Arrays.asList("j", "k", "l"));
        List<String> str6 = new ArrayList<>(Arrays.asList("m", "n", "o"));
        List<String> str7 = new ArrayList<>(Arrays.asList("p", "q", "r", "s"));
        List<String> str8 = new ArrayList<>(Arrays.asList("t", "u", "v"));
        List<String> str9 = new ArrayList<>(Arrays.asList("w", "x", "y", "z"));
        List<String> str0 = new ArrayList<>(Arrays.asList(" "));
        List<String> str1 = new ArrayList<>(Arrays.asList(" "));
        
    public List<String> letterCombinations(String digits) {
        // dfs
        List<String> res = new ArrayList<>();
        
        int len = digits.length();
        if(len<=0)  return res;
        
        stringsArray.add(str0);
        stringsArray.add(str1);
        stringsArray.add(str2);
        stringsArray.add(str3);
        stringsArray.add(str4);
        stringsArray.add(str5);
        stringsArray.add(str6);
        stringsArray.add(str7);
        stringsArray.add(str8);
        stringsArray.add(str9);
        
        StringBuilder str = new StringBuilder();
        
        dfs(digits, res, len, str, 0);
        return res;
    }
    
    /**
     * @param i: the i index char is to read
     */
    public void dfs(String digits, List<String> res, int len, StringBuilder sb, int i){
        // loop ends condition
        if (i==len){
            res.add(sb.toString());
            return ;
        }
        int x = Integer.parseInt(digits.substring(i, i+1));
        for (String y: stringsArray.get(x)){
            sb.append(y);
            dfs(digits, res, len, sb, i+1);
            sb.deleteCharAt(i);
        }
        return ;
    }
}