class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int idx = 0;
        Map<Integer, Integer> freqCounter= new HashMap<>();
        for(int i : nums){
            freqCounter.put(i,freqCounter.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> topK = new PriorityQueue<>(
            (a, b) -> a[0] - b[0] 
        );
        for(Map.Entry<Integer, Integer> freq: freqCounter.entrySet()){
             topK.add(new int[]{freq.getValue(), freq.getKey()});
            if(topK.size()>k){
                topK.poll();
            }

        }
        while(!topK.isEmpty()){
            result[idx++] =  topK.poll()[1];
        }
        return result;
        
    }
}
