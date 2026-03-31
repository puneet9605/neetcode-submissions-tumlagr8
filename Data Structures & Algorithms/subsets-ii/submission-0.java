class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        createSubset(nums, 0,new ArrayList<>());
        return res;
        
    }
    void createSubset(int[] nums, int start, List<Integer> curSubSet){
        res.add(new ArrayList<>(curSubSet));
        for(int i = start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            curSubSet.add(nums[i]);
            createSubset(nums,i+1, curSubSet);
            curSubSet.remove(curSubSet.size()-1);
        }

    }
}
