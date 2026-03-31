class Solution {
    int[] nums;
    int[][] dp;
    public int maxCoins(int[] arr) {
        int n = arr.length;
        nums = new int[n + 2];
        nums[0] = 1;
        nums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            nums[i + 1] = arr[i];
        }
        dp = new int[n + 2][n + 2];
        return dfs(0, n + 1);
        
    }
    int dfs(int l , int r){
        if(l+1>=r) return 0;
        if (dp[l][r] != 0) return dp[l][r];
         int max = 0;
         for(int k = l+1; k<r;k++){
            int coins = 
            dfs(l,k) + 
            nums[l]*nums[k]*nums[r] +
            dfs(k,r);
            max = Math.max(max, coins);
         }

        dp[l][r] = max;
        return max;


    }
}
