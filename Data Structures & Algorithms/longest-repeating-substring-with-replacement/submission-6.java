class Solution {
    public int characterReplacement(String s, int k) {
        s = s.toUpperCase();
        int max= 0;

        for(int i = 0; i < s.length(); i++){
            int curr = helper(s,k, i);
            if (curr > max){
                max = curr;
            }
        } 

        return max;
    }

    private int helper (String s, int k, int count) {
        char curr = s.charAt(count);
        int res = 0;
        for (int i = count; i < s.length(); i++){
            if (s.charAt(i) != curr){
                if (k == 0) break;
                else k--;
            }
            res++;
        }
        for (int i = count - 1; i>= 0; i--){
            if (s.charAt(i) != curr){
                if (k == 0) break;
                else k--;
            }
            res++;
        }
        return res ;
    }
}
