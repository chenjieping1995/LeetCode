public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        // 先取得点的个数 len, 初始化结果
        int len = points.length;
        int result = 0;
        
        // 声明一个Map集合，到某点距离K的点个数为V
        Map<Integer, Integer> store = new HashMap<>();
        
        // 对于集合中的每一个点(在此循环的计数中把它作为首元素)
        for (int i=0; i<len; i++){
            for (int j=0; j<len; j++){
                // 遍历集合中其他的点到这个点的距离, 存储到HashMap集中
                
                if (i == j)
                    continue;
                    
                int dis = getDistance(points[i], points[j]);
                
                // 如果距离键K已经有值V，V=V+1,否则,V=0+1=1
                store.put(dis, store.getOrDefault(dis, 0)+1);
            }

            // 最后,遍历V的集合,对于每个V,取组合数(V,2)*2加到result中
            for (int val: store.values()) {
                result += val*(val-1);
            }
            
            // 每计算完一个点,需要把store集清空
            store.clear();
        }
        return result;
    }
    
    public int getDistance(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
}