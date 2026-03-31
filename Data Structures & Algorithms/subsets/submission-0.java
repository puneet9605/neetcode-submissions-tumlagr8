class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        sub(nums, 0, new ArrayList<>());
        return res;
        
    }

    void sub(int[] nums, int i,List<Integer> currSub){
        if (i>=nums.length){
            res.add(new ArrayList<>(currSub));
            return;
        }
        sub(nums, i+1,currSub);
        currSub.add(nums[i]);

        sub(nums, i+1,currSub);
        currSub.remove(currSub.size() - 1);
    }

}
