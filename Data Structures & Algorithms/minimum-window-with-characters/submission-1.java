class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        Map<Character, Integer> tlist = new HashMap<>();
        Map<Character, Integer> slist = new HashMap<>();

        int resLength = Integer.MAX_VALUE;  // FIX 1: Use MAX_VALUE instead of s.length()
        String res = "";

        int need = 0;
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            tlist.put(curr, tlist.getOrDefault(curr, 0) + 1);
        }
        need = tlist.size();  // FIX 2: Count unique characters

        int left = 0;
        int have = 0;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            
            if (tlist.containsKey(curr)) {
                slist.put(curr, slist.getOrDefault(curr, 0) + 1);
                
                // FIX 3: Use .equals() for Integer comparison
                if (slist.get(curr).equals(tlist.get(curr))) {
                    have++;
                }
                
                while (have == need) {
                    // Update result if we found a smaller window
                    int currentLength = right - left + 1;
                    if (currentLength < resLength) {
                        resLength = currentLength;
                        res = s.substring(left, right + 1);
                    }
                    
                    // Remove left character from window
                    char lcurr = s.charAt(left);
                    if (tlist.containsKey(lcurr)) {
                        slist.put(lcurr, slist.get(lcurr) - 1);
                        
                        // Check if we lost a required character
                        if (slist.get(lcurr) < tlist.get(lcurr)) {
                            have--;
                        }
                    }
                    left++;
                }
            }
        }
        
        return resLength == Integer.MAX_VALUE ? "" : res;  // FIX 4: Handle no window case
    }
}