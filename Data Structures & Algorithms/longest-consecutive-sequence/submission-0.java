class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        int max = 0;
        for(int num: nums){
            numsSet.add(num);
        }
        for(int num: numsSet){
            int currLength = 1;
            int n = num;
            if(numsSet.contains(num-1)){
                continue;
            }
            else{
                while (numsSet.contains(n+1)){
                    currLength++;
                    n++;
                }

            }
            max = Math.max(currLength, max);
        }
        return max;
        
        
    }
}
