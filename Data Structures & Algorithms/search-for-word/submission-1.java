class Solution {
    int[][] dir = {
    {0, 1},    // right
    {0, -1},   // left
    {1, 0},    // down
    {-1, 0},   // up
};
    public boolean exist(char[][] board, String word) {
        for(int i =0;i<board.length; i++){
            for(int j =0; j< board[0].length; j++){
                if (dfs(board, i,j, word)==true){
                    return true;
                }
            }
        }
        return false;
        
        
    }
    boolean dfs(char [][]board, int i, int j, String word){
        if (word.length()==0){
            return true;
        }
        if( i>=board.length|| i<0 || j>=board[0].length || j< 0|| board[i][j]!=word.charAt(0)){
            return false;
        } else {
            char temp = board[i][j];
            board[i][j] = '#';
            for(int[] direction: dir){
                if (dfs(board, i+direction[0], j+ direction[1],word.substring(1))==true){
                    board[i][j] = temp;
                    return true;
                }
            }   
            board[i][j] = word.charAt(0);
            return false;

        }
    }
}
