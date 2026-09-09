class Solution {
    public int maxProfit(int[] prices) {
        int numStock = 0;
        int profit = 0;
        for (int i = 0; i < prices.length - 1 ; i++){
            if (numStock == 1){
                numStock--;
            }
            if (prices[i] < prices[i+1] && numStock == 0){
                profit = profit + (prices[i+1] - prices[i]);
                numStock++;
            }
        }
        int end = prices.length - 1;
        if (prices[end]>prices[end-1] && numStock == 0){
                profit = profit + (prices[end] - prices[end - 1]);
        }
        return profit;
    }
}