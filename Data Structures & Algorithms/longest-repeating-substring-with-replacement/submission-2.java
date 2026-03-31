class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int[] freqCount = new int[26];
        int right = 0;
        int left = 0;
        int ans=0;
        while(right<s.length()){
            freqCount[s.charAt(right)-'A']++;
            if(freqCount[s.charAt(right)-'A']>maxFreq){
                maxFreq= freqCount[s.charAt(right)-'A'];
            }
            while(maxFreq+k< right -left+1){
                freqCount[s.charAt(left)-'A']--;
                left++;
            }
            ans = Math.max(ans, right-left+1);
            right++;

        }
        return ans;
        
    }
}
