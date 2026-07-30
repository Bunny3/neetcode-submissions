class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());    
    }
    // maxHeap -- median -- minHeap
    public void addNum(int num) {
        if(minHeap.isEmpty()) {
            minHeap.add(num);
            return ;
        }
        if(num < minHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if(maxHeap.size()>minHeap.size()) {
            int val = maxHeap.poll();
            minHeap.add(val);
        }
        if(minHeap.size()>1+maxHeap.size()) {
            int val = minHeap.poll();
            maxHeap.add(val);
        }
    }
    
    public double findMedian() {
        //Print Minheap & MaxHeap
        System.out.print("Min heap: ");
        System.out.println(minHeap);
        System.out.print("Max heap: ");
        System.out.println(maxHeap);
        if(minHeap.size() == maxHeap.size()) 
        {
            return (double)(minHeap.peek()+maxHeap.peek())/2.0;
        }
        else {
            return minHeap.peek();
        }
    }
}
