class Solution {
    public String longestPalindrome(String s) {
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
