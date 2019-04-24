/***
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
***/
class Solution {
    
    
    public int binarySearch(int[] nums, int l , int r,  int target) {
        
        while(l <= r) {
            int mid = l + (r-l)/2;
            System.out.println(l + " " + r + " " + mid);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid]  < target) {
                l = mid +1;
            } else {
                r = mid -1; 
            }
        }
        System.out.println("inner return - 1" );
        return -1; 
    }
    public int search(int[] nums, int target) {
        
        if(null == nums || nums.length == 0)
            return -1;
        
        int len = nums.length;
        int pivot = 0 ; 
        for(int i = 1 ; i < len ; ++i) {
            if(nums[i] < nums[i-1]) {
                pivot = i; 
                break; 
            } 
        }
        System.out.println("pivot" + pivot);
        if(pivot ==0 ) {
            return binarySearch(nums, 0, len-1, target);
        } else if( target < nums[0]) {
            return binarySearch(nums, pivot, len-1, target);
        } else {
             return binarySearch(nums, 0, pivot-1, target);
        }  
    }
}
