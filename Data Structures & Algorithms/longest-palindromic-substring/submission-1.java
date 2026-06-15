class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0, resLen = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (resLen < j - i + 1) {
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }

    public String longestPalindrome_two_pointers(String s) {
        int n = s.length();

        int maxLen = 0;
        String result = "";
        for (int i = 0; i < n; i++) {
            String palindrome = help(s, n, i, i);
            if (palindrome.length() > maxLen) {
                maxLen = palindrome.length();
                result = palindrome;
            }

            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
              String palindrome2 = help(s, n, i - 1, i);
              if (palindrome2.length() > maxLen) {
                  maxLen = palindrome2.length();
                  result = palindrome2;
              }
            }
        }

        return result;
    }

    private String help(String s, int n, int start, int end) {
        while (start - 1 >= 0 && end + 1 < n && 
                s.charAt(start - 1) == s.charAt(end + 1)) {
                start--;
                end++;
        }

        return s.substring(start, end + 1);
    }
}
