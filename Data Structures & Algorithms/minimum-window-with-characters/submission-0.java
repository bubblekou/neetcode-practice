class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        int len = t.length();
        int i = 0, j = 0;
        int minWin = Integer.MAX_VALUE;
        int minWinStart = 0, minWinEnd = 0;

        Map<Character, Integer> runningCountMap = new HashMap<>();
        int meetCount = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            runningCountMap.put(ch, runningCountMap.getOrDefault(ch, 0) + 1);

            if (charCountMap.containsKey(ch) && runningCountMap.get(ch) <= charCountMap.get(ch)) {
                meetCount++;
            }

            // Shink i
            while (meetCount == len) {
                if (j - i + 1 < minWin) {
                    minWin = j - i + 1 ;
                    minWinStart = i;
                    minWinEnd = j;
                }
                char ch2 = s.charAt(i);
                if (charCountMap.containsKey(ch2) && runningCountMap.get(ch2) <= charCountMap.get(ch2)) {
                    meetCount--;
                }

                if (runningCountMap.get(ch2) == 1) {
                    runningCountMap.remove(ch2);
                } else {
                    runningCountMap.put(ch2, runningCountMap.get(ch2) - 1);
                }

                i++;
            }

            j++;
        }

        if (minWin == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minWinStart, minWinEnd + 1);
        }
    }
}
