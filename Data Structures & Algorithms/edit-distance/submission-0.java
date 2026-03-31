class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()+1][word2.length()+1];
        return dfs(word1, word2, 0, 0);
        
    }

    int dfs(String word1, String word2, int i, int j){
        if(i == word1.length() && j==word2.length()){
            return 0;
        }
        if (dp[i][j]!= null){
            return dp[i][j];
        }

        if(i == word1.length()){
            dp[i][j] = word2.length()-j;
            return  dp[i][j];
        }
        if (j == word2.length()){
            dp[i][j] = word1.length()-i;
            return dp[i][j];
        }
     
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = dfs(word1, word2, i+1, j+1);
            return dp[i][j];
        }
        int removed = 1+ dfs(word1, word2, i+1, j);
        int replaced = 1+ dfs(word1, word2, i+1, j+1);
        int inserted = 1 + dfs(word1, word2, i , j+1);
        int temp = Math.min(removed, replaced);
        dp[i][j] = Math.min(temp, inserted);
        return dp[i][j];

    }
}
