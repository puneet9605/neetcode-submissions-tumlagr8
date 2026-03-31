class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> mergedIntervals = new ArrayList();
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]<newInterval[0]){
                mergedIntervals.add(intervals[i]);
            } else if (intervals[i][0]>newInterval[1]){
                mergedIntervals.add(newInterval);
                newInterval = intervals[i];
                
            } else {
                newInterval[0]= Math.min(newInterval[0], intervals[i][0]);
                newInterval[1]= Math.max(newInterval[1], intervals[i][1]);
            }
        }
        mergedIntervals.add(newInterval);
        int[][] result = new int[mergedIntervals.size()][];
        for (int i = 0; i < mergedIntervals.size(); i++) {
        result[i] = mergedIntervals.get(i);
        }

    return result;

        
    }
}
