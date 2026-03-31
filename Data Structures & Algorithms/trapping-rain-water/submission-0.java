class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] rightRight = new int[height.length];
        int maxArea = 0;
        maxLeft[0] = height[0];
        for(int i = 1; i<height.length;i++){
            maxLeft[i]= Math.max(maxLeft[i-1], height[i]);
        }
        rightRight[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i>=0;i--){
            rightRight[i]= Math.max(rightRight[i+1], height[i]);
        }
        for(int i=0;i<height.length;i++){
        maxArea = maxArea + Math.min(rightRight[i], maxLeft[i]) - height[i];
        }
        return maxArea;
        
    }
}
