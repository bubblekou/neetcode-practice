class Solution {

    public String encode(List<String> strs) {
        // xxyyzzdd
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(String.format("%03d", s.length()));
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int len = str.length();
        int start = 0;

        while (start < len) {
            int currSize = Integer.parseInt(str.substring(start, start + 3));
            ans.add(str.substring(start + 3, start + 3 + currSize));
            start = start + 3 + currSize;
        }

        return ans;
    }
}
