class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i++){
            if (piles[i] > max) max = piles[i];
        }
        return helper(1, max , h, piles);
    }

    private int helper( int start, int end, int h, int[] piles){
        if (start > end) return start;
        int i = (start + end + 1) /2;
        int hours = 0;

        for (int j = 0; j < piles.length; j++){
            hours += (int)Math.ceil((double)piles[j] / i);
        }

        if (hours > h) return helper (i+1, end, h, piles);
        return helper(start, i-1, h, piles);
    }
}
