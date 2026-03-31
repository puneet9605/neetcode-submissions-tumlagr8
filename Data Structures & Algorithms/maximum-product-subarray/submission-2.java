class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 1;
        int minProduct = 1;
        int globalMax = Integer.MIN_VALUE;
        for(int num: nums){
            int x =  maxProduct*num;
            int y =  minProduct*num;
            maxProduct = Math.max(num, Math.max(x,y));
            minProduct = Math.min(num, Math.min(x,y));
            globalMax = Math.max(globalMax, maxProduct);
        }
        return globalMax;

        
    }
}
