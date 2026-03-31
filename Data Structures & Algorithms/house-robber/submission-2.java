class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int maxFirst = nums[0];
        int maxSecond = Math.max(nums[0], nums[1]);
        for(int i =2; i<nums.length;i++){
            int temp = maxSecond;
            maxSecond = Math.max(maxFirst+nums[i], maxSecond);
            maxFirst = temp;
        }
        return maxSecond;
        
    }
}
