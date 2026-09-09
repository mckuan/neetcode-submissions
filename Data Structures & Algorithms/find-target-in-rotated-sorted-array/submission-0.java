class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }
    
    private int helper(int[] nums, int target, int start, int end){
        if (start>end) return -1;
        int mid = (start+end)/2;
        if (nums[mid] == target) return mid;

        if (nums[mid] >= nums[start]){
            if (target >= nums[start] && target <= nums[mid]) return helper(nums, target, start, mid-1);
            return helper(nums, target, mid + 1, end);
        } 
        if (target >= nums[mid] && target <= nums[end]) return helper(nums, target, mid+1, end);
        return helper(nums, target, start, mid-1);
    }
}
