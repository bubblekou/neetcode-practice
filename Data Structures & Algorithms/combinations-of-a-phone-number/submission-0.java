class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, mapping, 0, new StringBuilder(), ans);  
        return ans;      
    }

    private void backtrack(String digits, String[] mapping, int idx, StringBuilder sb, 
      List<String> ans) {
        if (idx == digits.length()) {
            if (sb.length() > 0) {
                ans.add(sb.toString());
            }
            return;
        }

        int d = digits.charAt(idx) - '2';
        for (char ch : mapping[d].toCharArray()) {
            int originalLen = sb.length();
            sb.append(ch);
            backtrack(digits, mapping, idx + 1, sb, ans);
            sb.setLength(originalLen);
        }        
    }
}
