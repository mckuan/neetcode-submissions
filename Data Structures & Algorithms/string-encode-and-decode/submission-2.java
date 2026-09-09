class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (int i = 0; i < strs.size(); i++) {
            String curr = strs.get(i);
            res+= curr.length() + "#" + curr;
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int slash = str.indexOf('#', i);
            int size = Integer.parseInt(str.substring(i, slash));
            i = slash + 1;
            res.add(str.substring(i, i + size));
            i += size;
        }
        return res;
    }
}
