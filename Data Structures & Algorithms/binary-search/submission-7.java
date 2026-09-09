class Solution {
    public int search(int[] nums, int target) {
        return helper(0, nums.length-1, target, nums);
    }
    private int helper(int start, int end, int target, int[] nums){
        int i = (start+end)/2;
        if (start > end) return -1;
        if (nums[i] != target){
            if (nums[i] > target){
                return helper(start, i-1, target, nums);
            } else {
                return helper(i+1, end, target, nums);
            }
        } else {
            return i;
        } 
    }
}
