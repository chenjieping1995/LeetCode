public class Solution {

    List<List<String>> result = new ArrayList<List<String>>();
    
    public List<List<String>> solveNQueens(int n) {
        
        int[] array = new int[n];
        
        recursion(0, n, array);
        
        return result;
    }
    
    // 递归函数，每次传入当前行(棋子序)进行棋子摆放
    public void recursion(int i, int n, int[] array){
        if (i == n){
            // 如果此时已经完成了一组求解
            
            List<String> listStr = new ArrayList<String>();
            
            // 将本组解转换为字符串集合的形式
            for (int count=0; count<n; count++){
                StringBuilder Str = new StringBuilder();
                for (int k=0; k<array[count]; k++){
                    Str.append(".");
                }
                Str.append("Q");
                for (int k=array[count]+1; k<n; k++){
                    Str.append(".");
                }
                listStr.add(Str.toString());
            }
            
            // 把本组解加到答案中
            result.add(listStr);
            return;
        }
        
        // 对当前行的棋子进行列寻找
        for (int row=0; row<n; row++){
            int j=0;
            // 将棋子在不同的列尝试
            for (; j<i; j++){
                // i表示当前棋子所在行,j表示前面已经摆放的棋子
                if (array[j] == row) // 前面有棋子在该列
                    break;
                else if ((i+row) == (j+array[j])) // 45度线有冲突
                    break;
                else if ((j-array[j]) == (i-row))  // 135度线有冲突
                    break;
            }
            if (j == i) {
                // 棋子无冲突
                array[i] = row;
                recursion(i+1, n, array);
            }
        }
    }
    
}