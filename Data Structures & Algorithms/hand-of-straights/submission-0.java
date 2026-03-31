class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        SortedMap<Integer, Integer> sortedGroups = new TreeMap<>();
        for(int val:hand){
            sortedGroups.put(val,sortedGroups.getOrDefault(val,0)+1);
        }
        while(!sortedGroups.isEmpty()){
            int val = sortedGroups.firstKey();
            int freq = sortedGroups.get(val);
            for(int i=0;i<groupSize; i++){
                int cur=val+i;
                if(!sortedGroups.containsKey(cur) || sortedGroups.get(cur)<freq){
                    return false;
                } else if(sortedGroups.get(cur)==freq){
                    sortedGroups.remove(cur);
                } else{
                    sortedGroups.put(cur, sortedGroups.get(cur)-freq);
                }
            }
        }
        return true;
        
    }
}
