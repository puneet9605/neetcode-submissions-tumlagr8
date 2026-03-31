class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        return dfs(s,p,0,0);

        
    }

    boolean dfs(String s, String p, int i, int j){
        if (dp[i][j] != null) return dp[i][j];

        if (j == p.length()) {
            return dp[i][j] = (i == s.length());
        }
        boolean firstMatch =
                i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            dp[i][j] =
                    dfs(s, p, i, j + 2) ||          // skip x*
                    (firstMatch && dfs(s, p, i + 1, j)); // use x*
        } else {
            dp[i][j] =
                    firstMatch && dfs(s, p, i + 1, j + 1);
        }
        return dp[i][j];

    }
}
