class Solution {
    Map<Character, String> map;


    List<String> res;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        res = new ArrayList<>();
        if (digits.length() == 0){
            return res;
        }
        buildCombination(digits, 0, new StringBuilder());
        return res;
        
    }

    void buildCombination(String digit, int i,StringBuilder sb){
        if (i==digit.length()){
            res.add(sb.toString());
            return;
        }
        for(int j =0; j<map.get(digit.charAt(i)).length(); j++){
            sb.append(map.get(digit.charAt(i)).charAt(j));
            buildCombination(digit, i+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
