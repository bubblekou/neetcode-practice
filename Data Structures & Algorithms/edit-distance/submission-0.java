class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word1.length(), word2, word2.length());
    }

    private int dfs(String word1, int endOf1, String word2, int endOf2) {
        if (endOf1 == 0 && endOf2 == 0) {
            return 0;
        }

        // Insert a character from word 1
        if (endOf1 > 0 && endOf2 > 0 && word1.charAt(endOf1 - 1) == word2.charAt(endOf2 - 1)) {
              return dfs(word1, endOf1 - 1, word2, endOf2 - 1);
        } 

        int ans = Integer.MAX_VALUE;
        if (endOf1 > 0 && endOf2 > 0) {
            ans = Math.min(ans, 1 + dfs(word1, endOf1 - 1, word2, endOf2 - 1));
        }
        
        if (endOf1 > 0) {
            ans = Math.min(ans, 1 + dfs(word1, endOf1 - 1, word2, endOf2));
        } 
        
        if (endOf2 > 0) {
            ans = Math.min(ans, 1 + dfs(word1, endOf1, word2, endOf2 - 1));
        }

        return ans;
    }

}
