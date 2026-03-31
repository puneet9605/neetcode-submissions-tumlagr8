class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        Set<Integer> possible = new HashSet<>();
        possible.add(0);
        for(int num: nums){
            List<Integer> currSum = new ArrayList<>();
            for(int sums: possible){
                if(sums+num == target){
                    return true;
                }
                currSum.add(sums+num);
            }
            possible.addAll(currSum);
        }
        return false;
    }
}
