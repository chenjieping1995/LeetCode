public class Solution {

    List<List<String>> result = new ArrayList<List<String>>();
    
    public List<List<String>> solveNQueens(int n) {
        
        int[] array = new int[n];
        
        recursion(0, n, array);
        
        return result;
    }
    
    // �ݹ麯����ÿ�δ��뵱ǰ��(������)�������Ӱڷ�
    public void recursion(int i, int n, int[] array){
        if (i == n){
            // �����ʱ�Ѿ������һ�����
            
            List<String> listStr = new ArrayList<String>();
            
            // �������ת��Ϊ�ַ������ϵ���ʽ
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
            
            // �ѱ����ӵ�����
            result.add(listStr);
            return;
        }
        
        // �Ե�ǰ�е����ӽ�����Ѱ��
        for (int row=0; row<n; row++){
            int j=0;
            // �������ڲ�ͬ���г���
            for (; j<i; j++){
                // i��ʾ��ǰ����������,j��ʾǰ���Ѿ��ڷŵ�����
                if (array[j] == row) // ǰ���������ڸ���
                    break;
                else if ((i+row) == (j+array[j])) // 45�����г�ͻ
                    break;
                else if ((j-array[j]) == (i-row))  // 135�����г�ͻ
                    break;
            }
            if (j == i) {
                // �����޳�ͻ
                array[i] = row;
                recursion(i+1, n, array);
            }
        }
    }
    
}