class Solution {
    public int trap(int[] height) {
        int maxRight = height[height.length - 1];
        int maxLeft = height[0];
        int water = 0;

        int[] right = new int[height.length];

        for (int i = height.length - 1; i >= 0 ; i--){
            if (height[i] > maxRight) maxRight = height[i];
            right[i] = maxRight;
        }

        for (int i = 0; i< height.length - 1; i++){
            if (height[i] > maxLeft) maxLeft = height[i];

            int curr = Math.min(right[i], maxLeft) - height[i];
            water += curr > 0 ? curr : 0;
        }
        return water;


    }
}
