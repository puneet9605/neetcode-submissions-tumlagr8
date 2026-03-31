class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
        maxHeap.add(num);
        } else {
        minHeap.add(num);
        }
        if(Math.abs(minHeap.size()-maxHeap.size())>1){
            if (minHeap.size()>maxHeap.size()){
                maxHeap.add(minHeap.poll());

            } else{
                minHeap.add(maxHeap.poll());
            }
            
        }
    }
    
    public double findMedian() {
        if (minHeap.size()==maxHeap.size()){
            return (double) (minHeap.peek()+maxHeap.peek())/2;
        }
        return minHeap.size()>maxHeap.size()?minHeap.peek():maxHeap.peek(); 
        
    }
}
