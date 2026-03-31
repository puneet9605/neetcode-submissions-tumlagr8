class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        calcuateSum(nums, 0,target, new ArrayList<>());
        return res;
        
    }

    void calcuateSum(int[] nums,int index, int target, List<Integer> currItems){
        if (target==0){
            res.add(new ArrayList<>(currItems));
            return;
        }
        if (target<0 || index>=nums.length){
            return;
        }
        calcuateSum(nums,index+1,target, currItems);
        currItems.add(nums[index]);
        calcuateSum(nums,index,target-nums[index], currItems);
        currItems.remove(currItems.size()-1);

    }
}
