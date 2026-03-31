class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        createPermute(nums, new boolean[nums.length], new ArrayList());
        return res;

        
    }

    private void createPermute(int[] nums, boolean[] used,List<Integer> currRes){
        if (currRes.size()==nums.length){
            res.add(new ArrayList<>(currRes));
            return;
        }
        for(int i =0; i<nums.length;i++){
            if(used[i]==true){
                continue;
            }
            used[i] = true;
            currRes.add(nums[i]);
            createPermute(nums, used, currRes);
            used[i] = false;
            currRes.remove(currRes.size()-1);
        }

    }
}
