class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length -1;
        int sum = numbers[i]+numbers[j];

        while (sum != target) {
            if (target > sum) i++;
            if (sum > target) j--;

            sum = numbers[i]+numbers[j];
        }

        int[] res = new int[2];
        res[0] = i + 1;
        res[1] = j + 1;

        return res;
    }
}
