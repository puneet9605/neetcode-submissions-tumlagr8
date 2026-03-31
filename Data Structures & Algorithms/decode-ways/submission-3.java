class Solution {
    public int numDecodings(String s) {
        int ways1 = 1;
        int ways2 = 1;
        for(int i = s.length()-1; i>=0;i--){
            int ways = 0;
            if (s.charAt(i)>='1'){
                ways = ways1;
            }
            if(i<s.length()-1){
                int num = Integer.parseInt(s.substring(i,i+2 ));
                if (num>9 && num<27){
                    ways = ways+ ways2;
                }
            }
            int temp = ways1;
            ways1 = ways;
            ways2 = temp;
        }
        return ways1;
    }
   
}
