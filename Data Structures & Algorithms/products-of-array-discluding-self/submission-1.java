class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int pre = 1;
        int post = 1;

        for (int i = 0; i< nums.length; i++){
            pre *= nums[i];
            prefix[i] = pre;
        }

        for (int i = nums.length-1; i>0; i--){
            post *= nums[i];
            postfix[i] = post;
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++){
            if (i == 0) pre = 1;
            else pre = prefix[i-1];
            if (i == nums.length-1) post = 1;
            else post = postfix[i+1];

            res[i] = pre*post;
        }
        return res; 

    }
}  
