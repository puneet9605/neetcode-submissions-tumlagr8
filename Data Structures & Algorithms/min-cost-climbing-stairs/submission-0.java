class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==1){
            return cost[0];
        }
        if(n==2){
            return cost[0]<cost[1]? cost[0]:cost[1];
        }
        int[] costCache = new int[cost.length];
        costCache[n-1] = cost[n-1];
        costCache[n-2] = cost[n-2];
        for(int i =n-3; i>=0;i--){
            costCache[i]= cost[i]+Math.min(costCache[i+1], costCache[i+2]);
        }
        return costCache[0]<costCache[1]? costCache[0]:costCache[1];
        
    }
}
