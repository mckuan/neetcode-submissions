class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length];  // Track which numbers we've used
        backtracking(nums, cur, used);
        return res;
    }
    
    private void backtracking(int[] nums, List<Integer> cur, boolean[] used) {
        // BASE CASE: When we've used all numbers, we have a complete permutation
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));  // Add a COPY of the current permutation
            return;
        }
        
        // TRY EVERY NUMBER: For the next position in the permutation
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {  // Only try numbers we haven't used yet
                // STEP 1: CHOOSE
                cur.add(nums[i]);
                used[i] = true;
                
                // STEP 2: EXPLORE (recursively build the rest)
                backtracking(nums, cur, used);
                
                // STEP 3: UN-CHOOSE (backtrack)
                cur.remove(cur.size() - 1);  // Remove the last element
                used[i] = false;              // Mark it as unused again
            }
        }
    }
}