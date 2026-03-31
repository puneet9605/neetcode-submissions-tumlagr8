class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int lss = 0;
        int left = 0;
        int right = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            map[c]++;
            while (map[c]>1){
                map[s.charAt(left)]--;
                left++;
            }
            lss = Math.max(right-left+1, lss);
            right++;
        }
        return lss;
        
    }
}
