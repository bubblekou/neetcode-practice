class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();

        backtrack(s, 0, n - 1, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(String s, int start, int end, List<String> values, 
      List<List<String>> ans) {
        if (start > end) {
            List<String> copy = new ArrayList<>(values);
            ans.add(copy);
            return;
        }

        for (int cutoff = start; cutoff <= end; cutoff++) {
            if (!isPalindrome(s, start, cutoff)) continue;

            values.add(s.substring(start, cutoff + 1));
            backtrack(s, cutoff + 1, end, values, ans);
            values.removeLast();
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
