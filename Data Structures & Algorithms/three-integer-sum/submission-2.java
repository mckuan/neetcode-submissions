class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++){
            int curr = nums[i];
            int left = i+1;
            int right = nums.length-1;

            while (left != right && left < right){
                if(curr + nums[left] + nums[right] == 0){
                    List<Integer> set = new ArrayList<>();
                    set.add(curr);
                    set.add(nums[left]);
                    set.add(nums[right]);
                    if (!res.contains(set))res.add(set);
                    right--;
                    left++;
                } else if (curr + nums[left] + nums[right] > 0) right--;
                else left++;
            }

        }
        return res;
    }
}
