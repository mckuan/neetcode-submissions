class KthLargest {

    public PriorityQueue<Integer> minHeap;
    int limit;
    
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        limit = k;

        for (int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < limit){
            minHeap.add(val);
        } else {
            if (val > minHeap.peek()){
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}
