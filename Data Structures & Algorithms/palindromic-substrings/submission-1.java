class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }

    public int countSubstrings_two_pointers(String s) {
        int n = s.length();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += help(s, n, i, i);

            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
              ans += help(s, n, i - 1, i);
            }
        }

        return ans;
    }

    private int help(String s, int n, int start, int end) {
        int count = 1;
        while (start - 1 >= 0 && end + 1 < n && 
                s.charAt(start - 1) == s.charAt(end + 1)) {
                start--;
                end++;
                count++;
        }

        return count;
    }
}
