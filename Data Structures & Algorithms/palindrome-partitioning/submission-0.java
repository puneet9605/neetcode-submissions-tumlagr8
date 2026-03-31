class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        doPartiion(s, 0, new ArrayList<>());
        return res;
    }

    void doPartiion(String s, int i, List<String> currRes){
        if(i==s.length()){
            res.add(new ArrayList<>(currRes));
            return;
        }
        for(int start = i; start<s.length();start++){
            if(isPalindrome(s.substring(i, start+1))){
                currRes.add(s.substring(i, start+1));
                doPartiion(s, start+1, currRes);
                currRes.remove(currRes.size()-1);
            }
        }
    }

    boolean isPalindrome(String s){
        int i =0;
        int j =s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
