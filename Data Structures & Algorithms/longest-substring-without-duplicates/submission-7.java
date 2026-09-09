class Solution {
    public int res = 0;
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();

        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (characters.contains(ch)){
                i = i - curr;
                characters.clear();

                curr = 0;

            }
            else {
                characters.add(ch);
                curr++;
                res = Math.max(res,curr);
            }
        }
        return res;
    }
}
