class Solution {
    public int numDistinct(String s, String t) {
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
