class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 0 && t.length() == 0) return true;
        int[] characters = new int[26];

        for (int i = 0; i < s.length() ; i ++) {
            int currS = s.charAt(i) - 'a';
            int currT = t.charAt(i) - 'a';
            characters[currS]++;
            characters[currT]--;
        }

        for (int i = 0; i < characters.length; i++){
            if (characters[i] != 0) return false;
        }
        return true;

    }
}
