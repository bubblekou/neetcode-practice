class Solution {
    public boolean isAnagram(String s, String t) {
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
