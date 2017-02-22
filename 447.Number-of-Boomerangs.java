public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        // ��ȡ�õ�ĸ��� len, ��ʼ�����
        int len = points.length;
        int result = 0;
        
        // ����һ��Map���ϣ���ĳ�����K�ĵ����ΪV
        Map<Integer, Integer> store = new HashMap<>();
        
        // ���ڼ����е�ÿһ����(�ڴ�ѭ���ļ����а�����Ϊ��Ԫ��)
        for (int i=0; i<len; i++){
            for (int j=0; j<len; j++){
                // ���������������ĵ㵽�����ľ���, �洢��HashMap����
                
                if (i == j)
                    continue;
                    
                int dis = getDistance(points[i], points[j]);
                
                // ��������K�Ѿ���ֵV��V=V+1,����,V=0+1=1
                store.put(dis, store.getOrDefault(dis, 0)+1);
            }

            // ���,����V�ļ���,����ÿ��V,ȡ�����(V,2)*2�ӵ�result��
            for (int val: store.values()) {
                result += val*(val-1);
            }
            
            // ÿ������һ����,��Ҫ��store�����
            store.clear();
        }
        return result;
    }
    
    public int getDistance(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
}