/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals==null || intervals.size()<=1){
            return true;
        }
        Collections.sort(intervals, (a,b)-> a.start-b.start);
        int lastEndTime = intervals.get(0).end;
        for(int i=1; i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if (curr.start<lastEndTime){
                return false;
            }
            lastEndTime = curr.end;
        }
        return true;

    }
}
