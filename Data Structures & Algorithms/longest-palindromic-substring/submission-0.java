class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i =0; i<s.length();i++){
            int[] odd = longestPalindromeFromi(s,i,i);
            if(odd[1]-odd[0]-1>res.length()){
                res=s.substring(odd[0]+1, odd[1]);
            }
             int[] even = longestPalindromeFromi(s,i,i+1);
            if(even[1]-even[0]-1>res.length()){
                res=s.substring(even[0]+1,even[1]);
            }

        }
        return res;
        
    }
    int[] longestPalindromeFromi(String s, int left, int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++; 
        }
        return new int[]{left,right};

    }
}
