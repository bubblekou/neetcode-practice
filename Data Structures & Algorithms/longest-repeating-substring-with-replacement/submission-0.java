class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        int maxCharCount = 0, total = 0;
        char maxChar = s.charAt(0);

        int ans = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            if (charCountMap.get(ch) > maxCharCount) {
                maxCharCount = charCountMap.get(ch);
                maxChar = ch;
            }

            total++;

            while (total - maxCharCount > k) {
                char headChar = s.charAt(i);
                // System.out.println("Head char : " + headChar);
                if (charCountMap.get(headChar) == 1) {
                    charCountMap.remove(headChar);
                } else {
                    charCountMap.put(headChar, charCountMap.get(headChar) - 1);
                }

                if (headChar == maxChar) {
                    maxCharCount--;
                }

                total--;
                i++;
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }
}
