class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; // the length of the array
        int[] res = new int[n]; //the result will 
                        //always be the same length 

//prefix
        res[0] = 1; //set the first val to zero cuz we are using 
        // the suffix prefix product algo
        for (int i = 1; i < n; i++){ //traverse the array 
        //skipping first one
            res[i] = res[i - 1] * nums[i - 1]; //each cell is the 
            //product of the cell before it and the prev num cell
        }

//postfix
        int postfix = 1;//now we are starting from the end, 
        //this is like the res[0] = 1 but we already have a prefix
        for (int i = n - 1; i >= 0; i--){//now traversing the array backwards
            res[i] *= postfix;//each cell is multiplied to postfix
            postfix *= nums[i];//postfix is product of the last num cell and curr
        }
        return res;
    }
}  
