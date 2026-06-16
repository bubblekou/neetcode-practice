class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] canBreak = new boolean[n];
        return helper(s, n, wordDict, 0, canBreak);
    }

    private boolean helper(String s, int n, List<String> wordDict, int start,  boolean[] canBreak) {
        // System.out.println("start = " + start);
        if (start == n || canBreak[start]) {
            return true;
        }

        for (String w : wordDict) {
            // System.out.println("Processing " + w);
            int len = w.length();
            if (len > n - start) continue;
            if (!helper(s, n, wordDict, start + len, canBreak)) continue;
            if (s.substring(start, start + len).equals(w)) {
                canBreak[start] = true;
                return true;
            }
        }

        return false;
    }
}
