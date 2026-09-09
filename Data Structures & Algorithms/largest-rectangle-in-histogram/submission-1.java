class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> val = new Stack<>();
        int max = 0;

        for (int i = 0; i< heights.length; i++){
            int curr = heights[i];
            int count = 0;

            while (!val.isEmpty() && curr < val.peek()) {
                count ++; 
                int top = val.pop();
                if (max < top*count) max = top*count;
            }
            while (count != -1){
                val.push(curr);
                count --;
            }
        }
        
        int count = 0;
        while (!val.isEmpty()){
            count ++; 
            int top = val.pop();
            if (max < top*count) max = top*count;
        }
        return max;
    }
}
