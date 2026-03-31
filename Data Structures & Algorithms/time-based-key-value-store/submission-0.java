
class Node {
    public int timestamp;
    public String value;
    Node(int t, String s){
        timestamp = t;
        value = s;
    }

}

class TimeMap {
    Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new ArrayList<>()).add(new Node(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        String output = "";
        List<Node> list = map.get(key);
        int start = 0;
        int end = list.size()-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if (timestamp == list.get(mid).timestamp){
                return list.get(mid).value;

            }
            if (timestamp>list.get(mid).timestamp){
                output = list.get(mid).value;
                start = mid + 1; 
            } else 
            {
                end = mid -1;
            }

        }
        return output;
    }
}


