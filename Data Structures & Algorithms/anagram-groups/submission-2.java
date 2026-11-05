class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < strs.length; i++){
            String word = strs[i];
            int[] characters = new int[26];
            for (int j = 0; j < word.length(); j++) {
                characters[word.charAt(j)-'a']++;
            }

            String key = Arrays.toString(characters);

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(word);
        }

        for (String key: groups.keySet()){
            List<String> group = groups.get(key);
            res.add(group);
        }
    return res;
        
    }
}