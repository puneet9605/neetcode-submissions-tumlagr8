class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(char c: s.toCharArray()){
                freq[c-'a']++;
            }
            String v = Arrays.toString(freq);
            groups.computeIfAbsent(v, k->new ArrayList<>()).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> l : groups.values()){
            result.add(l);
        }
        return result;
    }
}
