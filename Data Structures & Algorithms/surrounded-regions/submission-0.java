class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i =0; i<n; i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0);
            }
            if(board[i][m-1]=='O'){
                dfs(board, i, m-1);
            }
        }
        for(int i =0; i<m; i++){
            if(board[0][i]=='O'){
                dfs(board, 0, i);
            }
            if(board[n-1][i]=='O'){
                dfs(board, n-1, i);
            }
        }
        for(int i =0; i<n; i++){
            for(int j =0; j<m;j++){
                if(board[i][j]=='O') {
                    board[i][j]= 'X';
                } else if(board[i][j]=='#') board[i][j]='O';
            }
        }
        
        
    }
    
    void dfs(char[][] board, int x, int y){
        board[x][y] = '#';
        for(int[] dir: dirs){
            int newX = x+ dir[0];
            int newY = y+ dir[1];
            if(newX>=0 && newY>=0 && newX<board.length && newY<board[0].length && board[newX][newY]=='O'){
                dfs(board, newX,newY);
            }
        }
         
    }
}
