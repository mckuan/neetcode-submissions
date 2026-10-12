public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }// if end word is not in wordlist or beg = end we return 0

        // We create an adjacency list the size of the word list
        int n = wordList.size();
        int m = wordList.get(0).length();
        List<List<Integer>> adj = new ArrayList<>(n);
        //for each entry just set it up so theres an empty list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }


        // we put the words from wordlist into the map 
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(wordList.get(i), i);
        }

        //for every pair of words (i, j) count how many characters diff
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = 0;
                //traversing characters
                for (int k = 0; k < m; k++) {
                    //if diff then update count
                    if (wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        cnt++;
                    }
                }
                //if they only differ by one, we add it to the adjacency list
                if (cnt == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }


// the bfs 
        //setting up for bfs
        Queue<Integer> q = new LinkedList<>();
        int res = 1;
        Set<Integer> visit = new HashSet<>();

        //for every letter
        for (int i = 0; i < m; i++) {
            //generating all possibilities
            for (char c = 'a'; c <= 'z'; c++) {
                //skip already there word
                if (c == beginWord.charAt(i)) {
                    continue;
                }
                //the new word, if its in the map and not visited before
                String word = beginWord.substring(0, i) + c + beginWord.substring(i + 1);
                if (mp.containsKey(word) && !visit.contains(mp.get(word))) {
                    //add it as a child and we add it to visited
                    q.add(mp.get(word));
                    visit.add(mp.get(word));
                }
            }
        }
        

        //qhile q is not empty, which means we are not done exploring all children
        while (!q.isEmpty()) {
            //update size
            res++;
            //size is q.size which is amount of children
            int size = q.size();

            //for every child
            for (int i = 0; i < size; i++) {
                //cur node is this one we are exploring this child
                int node = q.poll();

                //if its end of word then we can return
                if (wordList.get(node).equals(endWord)) {
                    return res;
                }
                //if not we check adjacency list, and we visit the neighbors
                for (int nei : adj.get(node)) {
                    if (!visit.contains(nei)) {
                        visit.add(nei);
                        q.add(nei);
                    }
                }
            }
        }

        //if we hit here we never reached the end word so we return 0
        return 0;
    }
}