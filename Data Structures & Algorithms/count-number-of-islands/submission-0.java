class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int numIslands(char[][] grid) {
        int num = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i =0; i<m; i++){
            for(int j =0;j<n; j++){
                if(grid[i][j]=='1'){
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }
    void dfs(char[][] grid, int x, int y){
        grid[x][y]= '0';
        for(int[] dir: dirs){
            int intX = x+dir[0];
            int intY = y+dir[1];
            if(intX>=0 &&
            intY>=0 &&
            intX<grid.length &&
            intY<grid[0].length &&
            grid[intX][intY]=='1') {
                dfs(grid, intX, intY);
            }
        }
        
    }
}
