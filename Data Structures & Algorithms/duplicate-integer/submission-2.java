class Solution {
    public boolean hasDuplicate(int[] nums) {
        PriorityQueue<Integer> list = new PriorityQueue<>();
        return helper (nums, list, 0);
    }
    private boolean helper(int[] nums, PriorityQueue<Integer> list , int i ){
        if (i >= nums.length) return false; 
        if (list.contains(nums[i])) return true;
        else {
            list.add(nums[i]);
            return helper(nums, list, ++i);
        }
    }
}