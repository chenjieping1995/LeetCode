public class Solution {
    public boolean isValid(String s) {
        
        int len = s.length();
        
        if (len==0) return true;
        
        if (len % 2 == 1)   return false;
        
        Stack stack = new Stack();
        
        for (int i=0; i<len; i++) {
            char x = s.charAt(i);
            
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
            } else {
                if (stack.empty())  return false;
                
                if (x==')' && (Character)stack.pop()=='(')
                    continue;
                else if (x==']' && (Character)stack.pop()=='[')
                    continue;
                else if (x=='}' && (Character)stack.pop()=='{')
                    continue;
                else return false;
            }
        }
        if (stack.empty())
            return true;
        else return false;
    }
}