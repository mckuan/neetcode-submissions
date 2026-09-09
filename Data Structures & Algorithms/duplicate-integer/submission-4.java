class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if (numbers.contains(curr)) return true;
            else numbers.add(curr);
        }
        return false;
    }
}