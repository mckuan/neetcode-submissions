class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        if (s.length() == 0) return 0;
       Set<Character> characters = new HashSet<>();
       int res = 0;
       int currStart = 0;
       int curr = 0; 

       while (curr < s.length()){
            if (characters.contains(s.charAt(curr))){
            res = Math.max(res, curr - currStart);
            currStart++;
            curr = currStart; 
            characters.clear();
            } else {
            characters.add(s.charAt(curr));
            curr++;
        }
       }
       if (curr == s.length()) {
            res = Math.max(res, curr - currStart);
       }
        
    
       return res;


    }
}
