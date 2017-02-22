public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
		// 采用先排序，两个指针向后走的算法
        int len1 = nums1.length;
        int len2 = nums2.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        while (i<len1 && j<len2){
            if (nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else if (nums1[i] > nums2[j]){
                j++;
            }
        }
        
		// 由于ArrayList中采用的Integer与int不是同种类型
		// 不能使用ArrayList的toArray方法转换
		// 这里采用的办法是 一个个元素取出 放入数组
        int[] array = new int[result.size()];
        for (i=0; i<array.length; i++){
            array[i] = result.get(i);
        }
        return array;
    }
}