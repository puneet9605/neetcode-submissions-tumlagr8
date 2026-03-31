class Solution {
    public String minWindow(String s, String t) {
        int[] freqT = new int[128];
        int need = t.length();
        String res ="";
        for(char c: t.toCharArray()){
            freqT[c]++;
        }

        int left = 0;
        int right = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            freqT[c]--;
            if (freqT[c]>=0){
                need--;
            }
            while(need==0){
                if (res.isEmpty() || right-left+1<res.length()){
                    res = s.substring(left,right+1);
                }
                char leftC = s.charAt(left);
                freqT[leftC]++;
                if (freqT[leftC]>0){
                need++;}
                left++;
            }
            right++;
        }
        return res;
        
    }
}
