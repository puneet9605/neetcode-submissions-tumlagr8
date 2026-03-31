class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
        for(List<String> ticket: tickets){
            adjMap.computeIfAbsent(ticket.get(0), k-> new PriorityQueue<>()).add(ticket.get(1));
        }
        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", adjMap, result);
        return result;

    }
    
    void dfs(
    String airport,
    Map<String, PriorityQueue<String>> adjMap,
    LinkedList<String> result){
        PriorityQueue<String> pq = adjMap.get(airport);
         while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();     
            dfs(next, adjMap, result);   
        }
        result.addFirst(airport);        
        
    }
}
