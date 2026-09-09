class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        if (nums[l] < nums[r]) return nums[l];   

        while (l < r) {
            int m = l + (r - l) / 2;
            
            if (nums[m] > nums[r]) {
                // Minimum is in the right half
                l = m + 1;
            } else {
                // Minimum is in the left half (including mid)
                r = m;
            }
        }
        return nums[l];
    }
}
