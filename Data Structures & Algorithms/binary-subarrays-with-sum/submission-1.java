class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count =0;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        int sum = 0;
        for(int num: nums){
            sum+=num;
            count+=prefix.getOrDefault(sum-goal, 0);
            prefix.put(sum, prefix.getOrDefault(sum, 0)+1);
        }
        return count;
        
    }
}