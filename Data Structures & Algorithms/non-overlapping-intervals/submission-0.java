class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        List<int[]> res= new ArrayList<>();
        int currend = intervals[0][1];
        int removal =0;
        for(int i =1;i<intervals.length; i++){
            if (currend<=intervals[i][0]){
                currend = intervals[i][1];
            } else {
                if(currend>intervals[i][1]){
                    currend = intervals[i][1];
                }
                removal++;
            }
        }
        return removal;
        
    }
}
