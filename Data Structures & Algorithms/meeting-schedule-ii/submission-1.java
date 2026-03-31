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
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> bookedRoom = new PriorityQueue<>();
        Collections.sort(intervals, (a,b)-> a.start-b.start);
        int res = 0;
        for(Interval interval:intervals){
            while(!bookedRoom.isEmpty() && bookedRoom.peek()<=interval.start){
                bookedRoom.poll();
            }
            bookedRoom.add(interval.end);
            res = Math.max(res, bookedRoom.size());
        }
        return res;


    }
}
