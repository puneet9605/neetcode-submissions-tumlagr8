class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        int totalFruit = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        //findtresure
        for(int i =0; i<m;i++){
            for(int j=0;j<n;j++)
            if(grid[i][j]==2) {
                queue.add(new int[]{i,j});
            } else {
                if (grid[i][j]==1){
                    totalFruit++;
                }
            }
        }
        if(totalFruit==0){
            return 0;
        }
        int curMin =-1;
        while(!queue.isEmpty()){
            int curLevel = queue.size();
            curMin++;
            while(curLevel!=0){
                int[] currPos = queue.removeFirst();
                for(int[] dir: dirs){
                    int newX = currPos[0]+dir[0];
                    int newY = currPos[1]+ dir[1];
                    if( newX>=0 &&
                    newY>=0 &&
                    newX<m &&
                    newY<n &&
                    grid[newX][newY] ==1 
                    ) {
                        grid[newX][newY] = 2;
                        totalFruit--;
                        queue.add(new int[]{newX, newY});
                    }
                }
                curLevel--;
            }
        }
        if(totalFruit==0){
            return curMin;
        }
        return -1;
        
        
    }
}
