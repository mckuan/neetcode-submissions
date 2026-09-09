class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> day = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++){
            int curr = temperatures[i];

            while (temp.size()!= 0 && curr > temp.peek() ){
                temp.pop();
                int tmp = day.pop();
                res[tmp] = i - tmp;
            }

            temp.push(curr);
            day.push(i);
            
        }
        return res;

    }
}
