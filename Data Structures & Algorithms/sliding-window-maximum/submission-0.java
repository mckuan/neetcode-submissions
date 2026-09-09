class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices
        
        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of current window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            
            // Remove from back all indices with values smaller than current nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add current index
            deque.offerLast(i);
            
            // The first element in deque is the largest for current window
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return res;
    }
}