class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int indexedQueries[][] = new int[queries.length][];
        for(int i=0; i<queries.length;i++){
            indexedQueries[i] = new int[]{i, queries[i]};
        }
        Arrays.sort(indexedQueries, (a,b)-> a[1]-b[1]);
        int[] res =new int[queries.length];
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        int j = 0;
        for(int i=0; i<indexedQueries.length;i++){
            while(j<intervals.length && intervals[j][0]<=indexedQueries[i][1]){
                pq.add(new int[] {intervals[j][0], 
                intervals[j][1], 
                intervals[j][1]- intervals[j][0] +1});
                j++;
            }
            while(!pq.isEmpty()&& pq.peek()[1]<indexedQueries[i][1]){
                pq.poll();
            }
            if(!pq.isEmpty()){
                res[indexedQueries[i][0]]= pq.peek()[2];
            } else{
                res[indexedQueries[i][0]]= -1;
            }

        }
        return res;
    }
}
