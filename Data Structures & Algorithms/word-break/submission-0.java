class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        for (String w : wordDict) {
            int len = w.length();
            if (len <= s.length() && wordBreak(s.substring(len), wordDict) && s.startsWith(w)) {
                return true;
            }
        }

        return false;
    }
}
