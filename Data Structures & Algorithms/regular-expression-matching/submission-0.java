class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        return dp(s, m, 0, p, n, 0);
    }

    private boolean dp(String s, int m, int i, String p, int n, int j) {
        if (i >= m) {
            return j == n || (j == n - 1 && p.charAt(n - 1) == '*');
        }

        if (j >= n) { // exhausted patterns
            return false;
        }
 
        if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
            return dp(s, m, i + 1, p, n, j + 1);
        } else if (p.charAt(j) == '*') { 
            boolean ans = false;
            // 0 occurance
            ans |= dp(s, m, i, p, n, j + 1);

            char charBefore = p.charAt(j - 1);
            if (charBefore == '.' || charBefore == s.charAt(i)) {
                // one occurance
                ans |= dp(s, m, i + 1, p, n, j);                
            } 
            return ans;
        } else {
            return false;
        } 
    }
}
