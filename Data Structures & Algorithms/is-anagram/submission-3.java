class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        for(char r: s.toCharArray()){
            freqS[r-'a']++;
        }
        for(char r: t.toCharArray()){
            freqT[r-'a']++;
        }
        return Arrays.toString(freqS).equals(Arrays.toString(freqT));


    }
}
