class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> merged = new ArrayList();
        int [] curr = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(curr[1]<intervals[i][0]){
                merged.add(curr);
                curr = intervals[i];
            } else if(curr[1]<intervals[i][1]){
                curr[1] = intervals[i][1];
            }
        } 
        merged.add(curr);
        int[][] res = new int[merged.size()][];
        int i =0;
        for(int[] interval: merged){
            res[i++]= interval;
        }
        return res;
    }
}
