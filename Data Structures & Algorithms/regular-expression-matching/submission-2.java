class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(s, m, 0, p, n, 0, memo);
    }

    private boolean dp(String s, int m, int i, String p, int n, int j, int[][] memo) {
        if (i >= m) {
            return j == n || (j == n - 1 && p.charAt(n - 1) == '*');
        }

        if (j >= n) { // exhausted patterns
            return false;
        }

        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean ans = false;
        if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
            ans = dp(s, m, i + 1, p, n, j + 1, memo);
        } else if (p.charAt(j) == '*') { 
            // 0 occurance
            ans |= dp(s, m, i, p, n, j + 1, memo);

            char charBefore = p.charAt(j - 1);
            if (!ans && (charBefore == '.' || charBefore == s.charAt(i))) {
                // one occurance
                ans |= dp(s, m, i + 1, p, n, j, memo);                
            } 
        } else {
            // Stop the wild card matching
            if (j + 1 < n && p.charAt(j + 1) == '*') {
                ans |= dp(s, m, i, p, n, j + 2, memo);
            }
        } 

        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}
