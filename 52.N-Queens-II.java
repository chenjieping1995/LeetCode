public class Solution {
    
    int result = 0;
    
    public int totalNQueens(int n) {
        // ��֮ǰ������,��η��ص��ǽ���ܸ���
        
        int[] array = new int[n];
        
        recursion(0, n, array);
        
        return result;
        
    }
    
    // ���ǲ��õݹ�İ취�����
    public void recursion(int x, int n, int[] array){
        if (x == n){
            // ���һ���
            result++;
            return ;
        }
        
        // ����
        for (int y=0; y<n; y++){
            int i=0;
            // i����֮ǰ������
            for (; i<x; i++){
                if (y == array[i])  // �г�ͻ
                    break;
                if ((x+y) == (i+array[i]))  // 45��б�߳�ͻ
                    break;
                if ((y-x) == (array[i]-i))  // 135��б�߳�ͻ
                    break;
            }
            if (i == x){
                // ���Ӱڷ�ǡ��
                array[x] = y;
                recursion(x+1, n, array);
            }
        }
    }
}