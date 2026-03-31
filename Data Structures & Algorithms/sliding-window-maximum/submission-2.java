class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] max = new int[nums.length-k+1];
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(!queue.isEmpty() && i-queue.peekFirst()>=k){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            if(i>=k-1){
                max[idx]= nums[queue.peekFirst()];
                idx++;
            }


        }
        return max;
        
    }
}
