class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        int prefix = strs[0].length();
        for(int i = 1; i<strs.length ; i++){
            int j =0;
            while( j<prefix && j<strs[i].length()){
                if(strs[i-1].charAt(j)!=strs[i].charAt(j)){
                    break;
                }
                j++;
            }
            if(j==0){
                return "";
            }
            prefix = j;

        }
        return strs[0].substring(0,prefix);
    }
}