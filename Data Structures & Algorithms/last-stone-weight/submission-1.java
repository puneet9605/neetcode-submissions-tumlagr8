class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)-> b-a);
        for(int stone: stones){
            pq.add(stone);
        }
        while(pq.size()>1){
            int s1 = pq.poll();
            int s2 = pq.poll();
            if(s1-s2 != 0){
                pq.add(s1-s2);
            }
        }
        return pq.isEmpty()? 0:pq.poll();
        
    }
}
