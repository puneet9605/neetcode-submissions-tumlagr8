class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i =0; i < s.length(); i++){
            if(dp[i]==true){
                
                for(int j =i; j<s.length();j++){
                if(words.contains(s.substring(i,j+1))){
                    dp[j+1] = dp[j+1] || dp[i];
                }
            }
                
            }

            
        }
        return dp[s.length()];
        
    }
}
