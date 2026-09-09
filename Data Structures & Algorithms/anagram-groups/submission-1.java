class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            String word = strs[i];
            int[] characters = new int[26];
            for (int j = 0; j < word.length(); j++) {
                characters[word.charAt(j)-'a']++;
            }

            String key = Arrays.toString(characters);
            if (groups.containsKey(key)) {
                groups.get(key).add(word);
            } else {
                List<String> anagram = new ArrayList<>(); 
                anagram.add(word);
                groups.put(key,anagram);
            }
        }
        List<List<String>> res = new ArrayList<>();
        groups.forEach((key,value) -> {
            res.add(value);
        });
    return res;
        
    }
}