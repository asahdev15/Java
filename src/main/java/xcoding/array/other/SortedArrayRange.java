package xcoding.array.other;


/**
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 *  Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */

class SortedArrayRange {
    
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        result[0] = leftIndex(nums, target);
        result[1] = rightIndex(nums, target);
        return result;
    }
    
    private static int leftIndex(int[] nums, int target){
        int index = -1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target <= nums[mid]){
                right = mid-1;
                if(target == nums[mid]){
                    index = mid;
                }
            }else{
                left = mid+1;
            }
            
        }
        return index;        
    }
    
    private static int rightIndex(int[] nums, int target){
        int index = -1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target >= nums[mid]){
                left = mid+1;
                if(target == nums[mid]){
                    index = mid;
                }
            }else{
                right = mid-1;
            }
            
        }
        return index;        
    }
    
    
}