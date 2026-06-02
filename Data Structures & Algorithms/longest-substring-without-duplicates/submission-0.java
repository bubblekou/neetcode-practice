class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charCount = new int[256];
        int i = 0, j = 0;
        int ans = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            while (charCount[ch] > 0) {
                charCount[s.charAt(i)]--;
                i++;
            }
            charCount[ch] = 1;
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }
}
