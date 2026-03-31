class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        Set<Character> inSubString = new HashSet<>();
        int index =0;
        while(index<s.length()){
            inSubString.add(s.charAt(index));
            int innerIndex = index;
            while(!inSubString.isEmpty()){
                char currChar = s.charAt(innerIndex);
                int numReq = map.get(currChar);
                inSubString.add(currChar);
                numReq--;
                if(numReq==0){
                    inSubString.remove(currChar);
                } else{
                    map.put(currChar, numReq);
                }
                innerIndex++;
            }
            res.add(innerIndex-index);
            index= innerIndex;

        }
        return res;
        
    }
}
