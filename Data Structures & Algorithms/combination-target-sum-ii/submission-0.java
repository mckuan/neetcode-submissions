class Solution {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        backtracking( candidates, target, cur, 0);
        return res;
        
    }

    private void backtracking (int[] candidates, int target, List<Integer> cur, int i){
        if (target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || i >= candidates.length){
            return;
        }

        // Try including current element
        cur.add(candidates[i]);
        backtracking(candidates, target - candidates[i], cur, i + 1);
        cur.remove(cur.size() - 1);
        
        // Skip duplicates (only when we're not taking this element)
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;  // Move past duplicates
        }
        // Skip current element entirely
        backtracking(candidates, target, cur, i + 1);
    }
}
