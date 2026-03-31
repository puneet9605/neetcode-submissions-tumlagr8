class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length-1;
        int iterator = nums.length-2;
        while(iterator>=0){
            if((nums[iterator]) + iterator>=goal){
                goal = iterator;
            }
            iterator--;

        }
        return (goal==0)? true: false;
        
    }
}
