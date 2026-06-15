class Solution {
    public int countSubstrings(String s) {
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
