class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right<s.length()){
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0)+1);
            while(freq.size()>k){
                int freqLeft= freq.get(s.charAt(left));
                if(freqLeft>1){
                    freq.put(s.charAt(left), freqLeft-1);
                } else{
                    freq.remove(s.charAt(left));
                }
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
        
    }
}
