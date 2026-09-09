class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        int i = 0;
        int j = heights.length - 1;


        while (i != j && i<j){
            int curr = (Math.min(heights[i], heights[j]))*(j-i);
            max = Math.max(curr, max); 
            if (heights[i] < heights[j]) i++;
            else j--;
        }
        return max;
        
    }
}
