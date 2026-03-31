class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        //findtresure
        for(int i =0; i<m;i++){
            for(int j=0;j<n;j++)
            if(grid[i][j]==0) {
                queue.add(new int[]{i,j});
            }
        }
        int steps = 0;
        while(!queue.isEmpty()){
            int lvlSize = queue.size();
            steps++;
            while(lvlSize>0){
                int[] curPostion = queue.removeFirst();
                int x = curPostion[0];
                int y = curPostion[1];
                lvlSize--;
                for(int dir[] : dirs){
                    int newX = dir[0]+x;
                    int newY = dir[1]+y;
                    if(newX>=0 && 
                    newX<m && 
                    newY>=0 && 
                    newY<n && 
                    grid[newX][newY]==Integer.MAX_VALUE){
                        grid[newX][newY] = steps;
                        queue.add(new int[]{newX, newY});
                    }
                }
            
            }

        }

    }
}
