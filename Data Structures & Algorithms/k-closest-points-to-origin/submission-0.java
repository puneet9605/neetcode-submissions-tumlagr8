class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<points.length; i++){
            int distance = points[i][0]*points[i][0] + points[i][1]* points[i][1];
            pq.add(new int[]{distance, i});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int [][] res = new int[pq.size()][];
        int i =0;
        while(!pq.isEmpty()){
            res[i++] = points[pq.poll()[1]];
        }
        return res;

    }
}
