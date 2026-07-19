class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }

    public List<Integer> partitionLabels2(String s) {
        List<Integer> ans = new ArrayList<>();

        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        Set<Character> charsWithLeftOver = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charCount.get(ch) == 1) {
                charCount.remove(ch);
                charsWithLeftOver.remove(ch);
            } else {
                charCount.put(ch, charCount.get(ch) - 1);
                charsWithLeftOver.add(ch);
            }

            if (charsWithLeftOver.isEmpty()) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }

        if (start < s.length()) {
            ans.add(s.length() - start);
        }

        return ans;
    }
}
