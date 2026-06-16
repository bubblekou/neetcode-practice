class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet, 0);
    }

    private boolean dfs(String s, Set<String> wordSet, int i) {
        // System.out.println("start = " + start);
        if (i == s.length()) {
            return true;
        }

        for (int j = i; j < s.length(); j++) {
            if (wordSet.contains(s.substring(i, j + 1))) {
                if (dfs(s, wordSet, j + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
