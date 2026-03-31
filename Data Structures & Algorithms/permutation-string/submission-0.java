class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        int[] freq = new int[26];
        for(char c: s1.toCharArray()){
            freq[c-'a']++;
        }       
        int need = s1.length();
        int left = 0;
        for(int right=0; right<s2.length();right++){
            char c = s2.charAt(right);
            if (freq[c - 'a'] > 0) {
                need--;
            }
            freq[c - 'a']--;
            if (right - left + 1 > s1.length()) {
                char leftChar = s2.charAt(left);
                if (freq[leftChar - 'a'] >= 0) {
                    need++;
                }
                freq[leftChar - 'a']++;
                left++;
            }
            if(need==0) return true;
        }
        return false; 
        
    }
}
