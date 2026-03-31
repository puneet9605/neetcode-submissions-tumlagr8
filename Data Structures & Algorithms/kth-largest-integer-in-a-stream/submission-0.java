class KthLargest {

    int size;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue();
        for(int i: nums){
            pq.add(i);
            if(pq.size()>size){
                pq.poll();
            }
        }

        
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>size){
            pq.poll();
        } 
        return pq.peek();

        
    }
}
