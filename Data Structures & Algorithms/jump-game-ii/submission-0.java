class Solution {
    public int jump(int[] nums) {
        int[] jumps= new int[nums.length];
        for(int n = nums.length-2; n>=0; n--){
            if(n+nums[n]>=nums.length-1){
                jumps[n]=1;
            } else {
                int x = n+nums[n];
                int min = 1000;
                while(x>n){
                    min = Math.min(min, jumps[x]);
                    x--;
                }
                jumps[n]=1+min;
            }
        }
        return jumps[0];

        
    }
}
