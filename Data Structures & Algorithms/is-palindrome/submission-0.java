class Solution {
    public boolean isPalindrome(String s) {
        s = s.replace(" ","");
        s = s.toLowerCase();
        String str = "";

        for (int i = 0; i < s.length(); i++){
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                str+=s.charAt(i)+"";
            }
        }

        for (int i = 0; i < str.length()/2; i++){
            int j = str.length()- i- 1;
            if(str.charAt(i)!= str.charAt(j)) return false;
        }
         return true;
    }
}
