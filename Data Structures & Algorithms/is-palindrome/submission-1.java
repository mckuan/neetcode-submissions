class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        for (int i = 0; i < s.length(); i++){
            if (Character.isLetter(s.charAt(i)) || 
            Character.isDigit(s.charAt(i))){
                str += s.charAt(i);                
            }
        }
        return helper(str);
        
    }

    public boolean helper(String s){
        if (s.length() == 0) return true;
        if (s.length()==1) return true;

        return(s.charAt(0) == s.charAt(s.length()-1) && 
        isPalindrome(s.substring(1, s.length()-1)));
    }
}
