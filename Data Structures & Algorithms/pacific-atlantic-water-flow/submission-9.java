class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int [][] toPacific = new int[m][n];
        Arrays.fill(toPacific[0],1);
        for(int i=0;i<m;i++){
            toPacific[i][0] =1;
        }
        for(int i=0;i<m;i++){
           dfs(heights, toPacific, i, 0, m,n);
        }
        for(int i = 0; i<n;i++){
            dfs(heights, toPacific, 0, i, m,n);
        }
        int [][] toAtlantic = new int[m][n];
        Arrays.fill(toAtlantic[m-1],1);
        for(int i=m-1;i>=0;i--){
            toAtlantic[i][n-1] =1;
        }
        for(int i=0;i<n;i++){
           dfs(heights, toAtlantic, m-1, i, m,n);
        }
        for(int i = 0; i<m;i++){
            dfs(heights, toAtlantic, i, m-1, m,n);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(toAtlantic[i][j]==1 && toPacific[i][j]==1){
                    List<Integer> match= new ArrayList<>();
                    match.add(i);
                    match.add(j);
                    res.add(match);
                }
            }
        }
        return res;
        

        
    }

    void dfs(int[][] heights, int[][] possible,int x, int y,
    int m, int n){
        for(int dir[]: dirs){
            int newX = x+ dir[0];
            int newY = y + dir[1];
            if(newX>=0 && 
            newY>=0 && 
            newX<m && 
            newY<n &&
            possible[newX][newY]!=1 &&
            heights[newX][newY]>=heights[x][y]
            ){
                possible[newX][newY] = 1;
                dfs(heights, possible, newX, newY, m,n);
            }
        }

    }
}
