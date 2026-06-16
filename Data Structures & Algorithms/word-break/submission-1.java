class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashSet<>());
    }

    private boolean helper(String s, List<String> wordDict, Set<String> canBreak) {
        if (s.isEmpty() || canBreak.contains(s)) {
            return true;
        }

        for (String w : wordDict) {
            int len = w.length();
            if (len <= s.length() && wordBreak(s.substring(len), wordDict) && s.startsWith(w)) {
                canBreak.add(s);
                return true;
            }
        }

        return false;
    }
}
