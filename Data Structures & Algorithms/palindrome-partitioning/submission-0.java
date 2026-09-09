class Solution {
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        
        List<String> curr = new ArrayList<>();
        backtrack(0, curr, s);
        return res;
    }
    
    private void backtrack(int start, List<String> curr, String s) {
        // BASE CASE: Reached the end of string
        if (start == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        // Try all possible ending positions from 'start'
        for (int end = start; end < s.length(); end++) {
            // Check if substring from start to end is palindrome
            if (isPalindrome(s, start, end)) {
                // DECISION: YES! Can partition here
                curr.add(s.substring(start, end + 1));
                
                // Recurse on the rest of the string
                backtrack(end + 1, curr, s);
                
                // Backtrack: Remove the last addition
                curr.remove(curr.size() - 1);
            }
            // If not palindrome: try longer substring (continue loop)
        }
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
