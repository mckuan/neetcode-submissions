class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, target, cur, 0);
        return res;
    }

    // backtrack function is usually recursion cleaner to take it outside
    // you could keep another variable to match target but go down to zero is easier
    private void backtrack(int[] nums, int target, List<Integer> cur, int i){
        if (target == 0){
            //when doing problems like this we add the copy not the thing
            res.add(new ArrayList<>(cur));
            return;
        } 
        if (target < 0 || i >= nums.length){
            return;
        } 

        cur.add(nums[i]);
        backtrack(nums, target-nums[i], cur, i );

        // list java is remove and give index which is size-1
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i+1);
    }
}
