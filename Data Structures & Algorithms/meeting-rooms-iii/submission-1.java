class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] res = new int[n];
        Arrays.sort(meetings, (a,b)-> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> freeRooms =
                new PriorityQueue<>(); 
        PriorityQueue<int[]> busyRooms = new  PriorityQueue<>((a,b) ->a[1] != b[1]
        ? Integer.compare(a[1], b[1])
        : Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }
        for(int[] meeting: meetings){
            int start = meeting[0];
            int end = meeting[1];            
            while (!busyRooms.isEmpty() && busyRooms.peek()[1] <= start) {
                freeRooms.add(busyRooms.poll()[0]);
            }
            if(!freeRooms.isEmpty()){
                int room = freeRooms.poll();
                res[room]++;
                busyRooms.add(new int[]{room, end});
            } else {
                int[] room = busyRooms.poll();
                res[room[0]]++;
                busyRooms.add(new int[]{room[0], room[1]+ (end-start)});
            }

        }
        int idx = 0;
        System.out.println(Arrays.toString(res));
        for(int i =0; i<n;i++){
            if(res[idx]<res[i]){
                idx = i;
            }

        }
        return idx;
    }
}