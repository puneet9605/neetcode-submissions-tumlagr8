class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String canonicalKey = new String(charArray);
            anagramGroups.computeIfAbsent(canonicalKey,k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramGroups.values());
        
    }
}
