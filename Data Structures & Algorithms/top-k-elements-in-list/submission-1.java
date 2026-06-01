class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num: nums){
            counter.put(num, counter.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[1]-b[1]));
        for(int key : counter.keySet()){
            pq.offer(new int []{key, counter.get(key)});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] result = new int[pq.size()];
        int i =0;
        while(!pq.isEmpty()){
            result[i++]=pq.poll()[0];
        }
        return result;

    }
}
