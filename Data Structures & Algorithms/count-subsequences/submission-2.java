class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            // one way to form empty string T (Think!!)
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }

    public int numDistinct_topdown(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(s, n, t, m, n, m, dp);
    }

    private int dfs(String s, int n, String t, int m, int endOfS, int endOfT, int[][] dp) {
        if (endOfS == 0 && endOfT == 0) {
            return 1;
        }

        if (endOfS < 1) {
            return 0;
        }

        if (dp[endOfS][endOfT] != -1) {
            return dp[endOfS][endOfT];
        }

        int ans = 0;
        if (endOfT > 0 && s.charAt(endOfS - 1) == t.charAt(endOfT - 1)) {
            ans += dfs(s, n, t, m, endOfS - 1, endOfT - 1, dp);
        }

        ans += dfs(s, n, t, m, endOfS - 1, endOfT, dp);

        dp[endOfS][endOfT] = ans;
        return ans;

    }
}
