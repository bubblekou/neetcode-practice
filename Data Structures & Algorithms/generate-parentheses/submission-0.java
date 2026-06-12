class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();

        List<String> ans = new ArrayList<>();
        backtrack(n, sb, 0, ans);
        return ans;
    }

    private void backtrack(int n, StringBuilder sb, int open, List<String> ans) {
        if (sb.length() == 2 * n && open == 0) {
            ans.add(sb.toString());
            return;
        }

        if (sb.length() + open < 2 * n) {
            int current = sb.length();
            sb.append('(');
            backtrack(n, sb, open + 1, ans);
            sb.setLength(current);
        }

        if (open > 0) {
            int current = sb.length();
            sb.append(')');
            backtrack(n, sb, open - 1, ans);
            sb.setLength(current);
        }
    }
}
