public class Solution {
    
    int result = 0;
    
    public int totalNQueens(int n) {
        // 与之前的类似,这次返回的是解的总个数
        
        int[] array = new int[n];
        
        recursion(0, n, array);
        
        return result;
        
    }
    
    // 还是采用递归的办法来求解
    public void recursion(int x, int n, int[] array){
        if (x == n){
            // 求得一组解
            result++;
            return ;
        }
        
        // 试列
        for (int y=0; y<n; y++){
            int i=0;
            // i代表之前的棋子
            for (; i<x; i++){
                if (y == array[i])  // 列冲突
                    break;
                if ((x+y) == (i+array[i]))  // 45度斜线冲突
                    break;
                if ((y-x) == (array[i]-i))  // 135度斜线冲突
                    break;
            }
            if (i == x){
                // 棋子摆放恰当
                array[x] = y;
                recursion(x+1, n, array);
            }
        }
    }
}