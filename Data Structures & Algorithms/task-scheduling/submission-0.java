class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task: tasks){
            freq[task-'A']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        int time =0;
        Deque<int[]>cooldownQueue= new ArrayDeque<>();
        for(int i =0; i< freq.length;i++){
            if(freq[i]>0) {
                pq.add(new int[]{freq[i], i});
            }
            
        }
        while(!cooldownQueue.isEmpty()|| !pq.isEmpty()){
            time++;
            if(!cooldownQueue.isEmpty()&&cooldownQueue.peekFirst()[2]==time){
                int [] cooledTask = cooldownQueue.removeFirst();
                pq.add(new int[]{cooledTask[0], cooledTask[1]});
            }
            if (!pq.isEmpty()){
            int [] currTask =pq.poll();
            currTask[0] = currTask[0]-1;
            if (currTask[0]>0){
                cooldownQueue.addLast(new int []{currTask[0], currTask[1], time+n+1});
            }
            }

        }
        return time;
        
    }
}
