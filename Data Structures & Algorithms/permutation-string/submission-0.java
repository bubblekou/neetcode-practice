class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        int len = s1.length();
        Map<Character, Integer> runningCountMap = new HashMap<>();
        int outOfBandCount = 0;
        int i = 0, j = 0;
        int n = s2.length();
        while (j < n) {
            char ch = s2.charAt(j);
            runningCountMap.put(ch, runningCountMap.getOrDefault(ch, 0) + 1);
            if (!charCountMap.containsKey(ch) || runningCountMap.get(ch) > charCountMap.get(ch)) {
                outOfBandCount++;
            }

            if (j - i == len) {
                char ch2 = s2.charAt(i);
                if (!charCountMap.containsKey(ch2) || runningCountMap.get(ch) > charCountMap.get(ch2)) {
                    outOfBandCount--;
                }

                if (runningCountMap.get(ch2) == 1) {
                    runningCountMap.remove(ch2);
                } else {
                    runningCountMap.put(ch2, runningCountMap.get(ch2) - 1);
                }
                i++;
            }

            if (j - i == len - 1 && outOfBandCount == 0) {
                return true;
            }

            j++;            
        }

        return false;
    }
}
