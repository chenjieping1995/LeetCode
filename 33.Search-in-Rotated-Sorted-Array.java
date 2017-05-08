public class Solution {
    // entry function & binary search
    public int search(int[] nums, int target) {
        // corner case 
        if (nums.length<=0) return -1;
        if (nums.length==1){
            if(nums[0]==target) return 0;
            return -1;
        }
        
        int minIndex = findMinIndex(nums);
        // the elements in array is in ascending order
        if (minIndex == -1){
            return binarySearch(nums, 0, nums.length-1, target);
        }
        
        if (target < nums[minIndex] || target > nums[minIndex-1])
            return -1;
        if (target >= nums[0]){
            return binarySearch(nums, 0, minIndex-1, target);
        } else {
            return binarySearch(nums, minIndex, nums.length-1, target);
        }
    }
    
    // find the min element index in array nums
    public int findMinIndex(int[] nums){
        int len=nums.length;
        for (int i=0; i<len-1; i++){
            if (nums[i]>nums[i+1])
                return i+1;
        }
        return -1;
    }
    
    // find the target element index in array using binary search
    public int binarySearch(int[] nums, int begin, int end, int target){
        int middle = (end + begin) / 2;
        while (nums[middle] != target && begin < end){
            if (target > nums[middle]){
                begin = middle+1;
                middle = (end+begin)/2;
            } else {
                end = middle-1;
                middle = (begin+end)/2;
            }
        }
        if (nums[middle] == target) return middle;
        else return -1;
    }
}