class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();
       for (int i = 0; i < nums.length; i++){
            numbers.put(nums[i], i);
       }
       for (int i = 0; i< nums.length; i++){
            int tmp = target-nums[i];
            if (numbers.containsKey(tmp) && i != numbers.get(tmp)) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = numbers.get(tmp);
                return res;
            }
       }
       return null;
    }
}
