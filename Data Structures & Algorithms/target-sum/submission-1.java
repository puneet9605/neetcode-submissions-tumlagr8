class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,0 ,target);
        
    }
    int dfs(int[] nums, int index,int target){
        if(index==nums.length){
            if(target==0){
                return 1;
            } else{
                return 0;
            }
        }
        return dfs(nums, index+1, target+nums[index])+ dfs(nums, index+1, target-nums[index]);
    }
}
