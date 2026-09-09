class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> blank = new ArrayList<>(0);

        res.add(blank);

        for (int i = 0; i < length; i++){
            int currsize = res.size();
            for (int j = 0; j < currsize; j++){
                List<Integer> subset = new ArrayList<>(res.get(j));
                subset.add(nums[i]);
                res.add(subset);
            }
        }

        return res;
    }
}
