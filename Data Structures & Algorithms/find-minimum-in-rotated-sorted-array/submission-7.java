class Solution {
    public int findMin(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private int helper(int[] nums, int start, int end){
        if (start > end) return nums[end];
        if (nums[start] <= nums[end]) return nums[start];
        int mid = (start+end)/2;
        if (nums[mid] >= nums[start]) return helper(nums,mid+1,end);
        return helper(nums, start, mid);
    }
}

//you could do this iteratively with while not recursion
