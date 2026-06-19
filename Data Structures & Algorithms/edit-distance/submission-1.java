class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(word1, word1.length(), word2, word2.length(), dp);
    }

    private int dfs(String word1, int endOf1, String word2, int endOf2, int[][] dp) {
        if (endOf1 == 0 && endOf2 == 0) {
            return 0;
        }

        if (dp[endOf1][endOf2] != -1) {
            return dp[endOf1][endOf2];
        }

        // Insert a character from word 1
        if (endOf1 > 0 && endOf2 > 0 && word1.charAt(endOf1 - 1) == word2.charAt(endOf2 - 1)) {
            int ans = dfs(word1, endOf1 - 1, word2, endOf2 - 1, dp);
            dp[endOf1][endOf2] = ans;
            return ans;
        } 

        int ans = Integer.MAX_VALUE;
        if (endOf1 > 0 && endOf2 > 0) {
            ans = Math.min(ans, 1 + dfs(word1, endOf1 - 1, word2, endOf2 - 1, dp));
        }
        
        if (endOf1 > 0) {
            ans = Math.min(ans, 1 + dfs(word1, endOf1 - 1, word2, endOf2, dp));
        } 
        
        if (endOf2 > 0) {
            ans = Math.min(ans, 1 + dfs(word1, endOf1, word2, endOf2 - 1, dp));
        }

        dp[endOf1][endOf2] = ans;
        return ans;
    }

}
