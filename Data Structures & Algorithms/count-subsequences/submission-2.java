class Solution {
    Integer[][] memo;
    public int numDistinct(String s, String t) {
        memo = new Integer[s.length()][t.length()];
        return dfs(s,t,0,0);
        
    }
    int dfs(String s, String t, int i , int j){
        if(j==t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            memo[i][j] = dfs(s,t, i+1, j+1) + dfs(s,t,i+1,j);
            return  memo[i][j];
        } else {
            memo[i][j] = dfs(s,t,i+1, j);
            return  memo[i][j];
        }
    }
}
