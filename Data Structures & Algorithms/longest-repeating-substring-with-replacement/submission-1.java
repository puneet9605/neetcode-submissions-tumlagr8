class Solution {
    public int characterReplacement(String s, int k) {
        int[] sA = new int[26];
        int max = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while(right<s.length()){
            sA[s.charAt(right)-'A']++;
            max = Math.max(max, sA[s.charAt(right)-'A']);
            while((right-left+1)-max>k){
                sA[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right-left+1);

            right++;
        }
        return res;
        
    }
}
