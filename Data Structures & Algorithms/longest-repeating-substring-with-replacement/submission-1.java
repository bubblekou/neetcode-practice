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
            
            // Always recalculate the max frequency in the current window
            maxCharCount = 0;
            for (int count : charCountMap.values()) {
                maxCharCount = Math.max(maxCharCount, count);
            }

            total++;

            while (total - maxCharCount > k) {
                char headChar = s.charAt(i);
                charCountMap.put(headChar, charCountMap.get(headChar) - 1);

                // Recalculate maxCharCount after removing the head element
                maxCharCount = 0;
                for (int count : charCountMap.values()) {
                    maxCharCount = Math.max(maxCharCount, count);
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
