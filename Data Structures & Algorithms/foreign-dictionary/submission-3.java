class Solution {
    StringBuilder sb;
    public String foreignDictionary(String[] words) {
        sb = new StringBuilder();
        if(words.length==1){
            return words[0];
        }
        Map<Character, List<Character>> adjList = new HashMap<>();
        String first = words[0];
        for(int i = 1 ; i<words.length; i++){
            if(!buildList(adjList, first, words[i])) return "";
            first = words[i];
        }
        int[] visited = new int[26];
        for(Character c: adjList.keySet()){
            if(!checkCycleBuildResult(c, adjList, visited)) return "";
        }
        sb.reverse();
        return sb.toString();

      
    }

    boolean checkCycleBuildResult(Character c , Map<Character, List<Character>> adjList, int[] visited ){
        if(visited[c-'a']==1){
            return true;
        }
        if(visited[c-'a']==2){
            return false;
        }
        visited[c-'a']=2;
        for(Character nextChar: adjList.get(c)){
           if (!checkCycleBuildResult(nextChar, adjList, visited)) return false; 
        }
        sb.append(c);
        visited[c-'a']=1;
        return true;
    }

    void addToList(Map<Character, List<Character>> adjList, String word1){
        for(Character c : word1.toCharArray()){
            adjList.computeIfAbsent(c, k-> new ArrayList<>());
        }
    }


    boolean buildList(Map<Character, List<Character>> adjList, String word1, String word2){
        addToList(adjList, word1);
        addToList(adjList, word2);

        int i = 0;
        while(i<word1.length() && i<word2.length()) {
            if(word1.charAt(i)==word2.charAt(i)){
                i++;
                continue;
            }
            adjList.get(word1.charAt(i)).add(word2.charAt(i));
            return true;
        }
        if(word1.length()>word2.length()){
            return false;
        }
        return true;

    }

    
}
