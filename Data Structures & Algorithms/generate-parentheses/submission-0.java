class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) return null;
        backtrack(0,0,"", n);
        return res;
    }

// n open, n close
//close < open can add close
    private void backtrack(int open, int close, String s, int n){
        if (open == n && close == n){
            res.add (s);
            return;
        }

        if (open < n) {
            backtrack( open + 1, close, s + "(", n);
        }

        if (close < open){
            backtrack( open, close+1, s+")", n);
        }
    }
}
