class Solution {
    int[][] dp;
    int max;
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        max =1;
        
        dp = new int[matrix.length][matrix[0].length];
        for(int[] row: dp){ Arrays.fill(row, 1); }
        for(int i =0; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                 dfs(matrix, i, j);
            }
        }
       
        return max;
    }

    int dfs(int[][] matrix, int x, int y){
        for(int[] dir: dirs){
            int i = x + dir[0];
            int j = y + dir[1];
            if(i>=0 && 
            i<matrix.length && 
            j>=0 && 
            j<matrix[0].length && 
            matrix[x][y]>matrix[i][j]){
                dp[x][y] = Math.max(1 +  dfs(matrix, i, j), dp[x][y]);
                max = Math.max(dp[x][y], max);
            }

        }
        return dp[x][y];
        
    }
    
}
