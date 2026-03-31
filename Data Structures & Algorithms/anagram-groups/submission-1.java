class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strsMap = new HashMap<>();
        for(String str: strs){
            int[] freq = new int[26];
            for(char r: str.toCharArray()){
                freq[r-'a']++;
            }
            strsMap.computeIfAbsent(Arrays.toString(freq),k-> new ArrayList<>()).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key: strsMap.keySet()){
            res.add(strsMap.get(key));

        }
        return res;

        
    }
}
