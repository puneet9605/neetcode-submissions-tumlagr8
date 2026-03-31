class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> incHeights = new ArrayDeque();
        int maxArea = 0;
        for(int i =0;i<heights.length; i++){
            if(incHeights.isEmpty()){
                incHeights.addLast(new int[] {i, heights[i]});
            } else if(incHeights.peekLast()[1]<heights[i]){
                incHeights.addLast(new int[] {i, heights[i]});
            } else {
                int start=i;
                while (!incHeights.isEmpty() && incHeights.peekLast()[1]>heights[i]) {
                    int[] lastHeight = incHeights.removeLast();
                    start = lastHeight[0];
                    maxArea = Math.max(maxArea,lastHeight[1]*(i- lastHeight[0]));
                }
                incHeights.addLast(new int[] {start, heights[i]});
            }
        }
        int n = heights.length;
        while (!incHeights.isEmpty()) {
            int[] lastHeight = incHeights.removeLast();
            maxArea = Math.max(maxArea, lastHeight[1]*(n- lastHeight[0]));
            }

        return maxArea;
    }
}
