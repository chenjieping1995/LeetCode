public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> interSet = new HashSet<Integer>();
        
        for (int i=0; i<len1; i++)
            set.add(nums1[i]);
            
        for (int i=0; i<len2; i++)
            if (set.contains(nums2[i]))
                interSet.add(nums2[i]);
        
        int result[] = new int[interSet.size()];
        int count = 0;
        for (int num:interSet)
            result[count++] = num;
        
        return result;
    }
}