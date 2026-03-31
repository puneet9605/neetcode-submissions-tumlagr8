class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i =0; i<m; i++){
            for(int j =0;j<n; j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    int dfs(int[][] grid, int x, int y){
        grid[x][y]= 0;
        int area =1;
        for(int[] dir: dirs){
            int intX = x+dir[0];
            int intY = y+dir[1];
            if(intX>=0 &&
            intY>=0 &&
            intX<grid.length &&
            intY<grid[0].length &&
            grid[intX][intY]==1) {
                area += dfs(grid, intX, intY);
            }
        } 
        return area;
    }
}
