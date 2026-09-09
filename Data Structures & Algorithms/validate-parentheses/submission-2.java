class Solution {
    public boolean isValid(String s) {
        Stack<Character> track = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if (track.size() != 0){
                if (isValidHelper(track.peek(), curr)) track.pop();
                else track.push(curr);
            } else track.push(curr);
        }
        if (track.size() == 0) return true;
        return false;
    }
    private boolean isValidHelper(char type, char match){
        if (type == '(' && match == ')') return true;
            else if (type == '{' && match == '}') return true;
            else if (type == '[' && match == ']') return true;
            else return false;
    }
    
}
