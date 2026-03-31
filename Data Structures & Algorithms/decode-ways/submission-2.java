class Solution {
    Map<Integer, Integer> memo = new HashMap<>(); 
    public int numDecodings(String s) {
        memo.put(s.length(),1);
        return helper(s, 0);
    }

    int helper(String s, int n){
        if(memo.containsKey(n)) return memo.get(n);
        int ways=0;
        if(s.charAt(n)>'0' && s.charAt(n)<='9'){
            ways = helper(s, n+1);
            
        }
        if (n<s.length()-1){
            int val = Integer.parseInt(s.substring(n, n+2));
            if (val>9&&val<27) ways = ways+ helper(s, n+2);
        }
        memo.put(n, ways);
        return ways;
        
    }
}
