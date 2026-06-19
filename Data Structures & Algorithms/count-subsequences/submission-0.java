class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        return dfs(s, n, t, m, n, m);
    }

    private int dfs(String s, int n, String t, int m, int endOfS, int endOfT) {
        if (endOfS == 0 && endOfT == 0) {
            return 1;
        }

        if (endOfS < 1) {
            return 0;
        }

        int ans = 0;
        if (endOfT > 0 && s.charAt(endOfS - 1) == t.charAt(endOfT - 1)) {
            ans += dfs(s, n, t, m, endOfS - 1, endOfT - 1);
        }

        ans += dfs(s, n, t, m, endOfS - 1, endOfT);

        return ans;

    }
}
