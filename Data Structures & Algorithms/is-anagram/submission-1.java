class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            if (charCount[ch - 'a'] == 0) {
                return false;
            }
            charCount[ch - 'a']--;
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!charMap.containsKey(ch)) {
                return false;
            }
            int cnt = charMap.get(ch);
            if (cnt == 1) {
                charMap.remove(ch);
            } else {
                charMap.put(ch, cnt - 1);
            }
        }

        return true;
    }
}
