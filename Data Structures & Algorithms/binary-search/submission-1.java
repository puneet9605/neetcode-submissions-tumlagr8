class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int mid = nums.length/2;
        int end = nums.length-1;
        while(start<=end){
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                start = mid+1;
               
            } else {
                end = mid-1;
            }
            mid = (start + end)/2;
        }
        return -1;
        
    }
}
