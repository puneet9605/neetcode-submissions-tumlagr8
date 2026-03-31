class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        gen(n, 0, new StringBuilder());
        return res;
        
    }
    void gen(int open, int close, StringBuilder sb){
        if(open == 0 && close== 0){
            res.add(sb.toString());
            return;
        }
        if(close>0){
            gen(open, close-1, sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }
        if(open>0){
            gen(open-1, close+1, sb.append('('));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
