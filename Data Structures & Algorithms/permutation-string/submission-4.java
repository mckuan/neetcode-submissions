class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] origcharacters = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            origcharacters[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        int[] characters = origcharacters.clone();

        for (right = 0; right < s2.length(); right++){
            int curr = s2.charAt(right) - 'a';
            
            characters[curr]--;
            
            while (characters[curr] < 0){
                characters[s2.charAt(left) - 'a'] ++;
                left++;
            }
              

            if (right - left + 1 == s1.length()) return true;
        }
        return false;
    }
        
}







