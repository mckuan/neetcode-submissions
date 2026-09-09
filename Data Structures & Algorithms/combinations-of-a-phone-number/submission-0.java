class Solution {

    List<String> res = new ArrayList<>();
    Map<Integer, String> phone = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0 )return res;

        phone.put(2, "abc");  // 3 letters
        phone.put(3, "def");  // 3 letters
        phone.put(4, "ghi");  // 3 letters
        phone.put(5, "jkl");  // 3 letters
        phone.put(6, "mno");  // 3 letters
        phone.put(7, "pqrs"); // 4 letters!
        phone.put(8, "tuv");  // 3 letters
        phone.put(9, "wxyz"); // 4 letters!   
        
        backtrack (0 , digits, "");
        return res;
    }

    private void backtrack( int index, String digits, String curr) {
        // decision which digit to take 

        if (index == digits.length()){
            res.add(new String(curr));
            return;
        }

        String letters = phone.get(digits.charAt(index) - '0');

        for (int i = 0; i < letters.length(); i++ ){           
            backtrack( index + 1, digits, curr + letters.charAt(i));
        }
        //in a for loop, go through all teh digits
            //recurse
            //undo before end of each loop 

        
        //BACKTRACK
        //called backtracking because we always recurse and then remove our decision!!!!

    }
}
