class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            Arrays.fill(dp[i], -1);
        }

        if (len1 + len2 != len3) {
            return false;
        }

        return dfs(s1, len1, 0, s2, len2, 0, s3, dp);       
    }

    private boolean dfs(String s1, int len1, int i, String s2, int len2, int j, 
      String s3, int[][] dp) {
        if (i == len1 && j == len2) {
            return true;
        }

        if (i > len1 || j > len2 || (i + j) >= s3.length()) {
            return false;
        }

        if (i < len1 && j < len2 && dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean res = false;
        if (i < len1 && s3.charAt(i + j) == s1.charAt(i)) {
            res = dfs(s1, len1, i + 1, s2, len2, j, s3, dp);
        }

        if (j < len2 && s3.charAt(i + j) == s2.charAt(j) && !res) {
            res = dfs(s1, len1, i, s2, len2, j + 1, s3, dp);
        }

        if (i < len1 && j < len2) {
            dp[i][j] = res ?  1 : 0;
        }

        return res;
    }
}
