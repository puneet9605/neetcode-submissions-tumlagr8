class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] time: times){
            adjList.get(time[0]).add(new int[]{time[1], time[2]});    
        }
        Set<Integer> visted = new HashSet<>(); 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]- b[1]);
        pq.add(new int[]{k,0});
        
        while(!pq.isEmpty()){
            int[] currNode = pq.poll();
            visted.add(currNode[0]);
            System.out.println(visted);
            if (visted.size()==n){
                return currNode[1];}
            for(int[] neigh: adjList.get(currNode[0])){
                if(!visted.contains(neigh[0])){
                    pq.add(new int[]{neigh[0], currNode[1]+ neigh[1]});
                }
            }

        }
        return -1;
        

        
    }
}
