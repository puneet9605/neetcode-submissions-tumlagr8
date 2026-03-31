class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        putQueen(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), new ArrayList<>());
        return res;
    }
    void putQueen(int n, int row,Set<Integer> col, Set<Integer> diag, Set<Integer> diagReverse, List<String> ans){
        if(row>=n){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int curCol =0; curCol<n ; curCol++){
            if(col.contains(curCol) || diag.contains((row - curCol) + (n - 1)) || diagReverse.contains(row + curCol)) {
                continue;
            } else {
                char[] temp = new char[n];
                Arrays.fill(temp, '.');
                col.add(curCol);
                temp[curCol] = 'Q';
                ans.add(new String(temp));
                diag.add((row - curCol) + (n - 1));
                diagReverse.add(row + curCol);
                putQueen(n, row+1, col, diag, diagReverse, ans);
                ans.remove(ans.size()-1);
                col.remove(curCol);
                diag.remove((row - curCol) + (n - 1));
                diagReverse.remove(row + curCol);
            }   
        }
    }
}