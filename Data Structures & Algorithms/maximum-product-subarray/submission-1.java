class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 1;
        int minProduct = 1;
        int globalMax = Integer.MIN_VALUE;
        for(int num: nums){
            int x =  maxProduct*num;
            int y =  minProduct*num;
            maxProduct = Math.max(x,y);
            maxProduct = Math.max(num, maxProduct);
            minProduct = Math.min(x,y);
            minProduct = Math.min(minProduct, num);
            globalMax = Math.max(globalMax, maxProduct);
        }
        return globalMax;

        
    }
}
