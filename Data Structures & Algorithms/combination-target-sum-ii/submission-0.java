class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        combinator(candidates, target, new ArrayList(), 0);
        return res;
    }
    void combinator(int[] candidates, int target,List<Integer> currSum, int index){
        if(target==0){
            res.add(new ArrayList(currSum));
            return;
        }
        for(int i = index; i<candidates.length;i++){
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
        if (candidates[i] > target) break;
        currSum.add(candidates[i]);
        combinator(candidates, target-candidates[i], currSum, i+1);
        currSum.remove(currSum.size()-1);
        }


    }
}
