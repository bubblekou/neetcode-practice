class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;

        int[] indegree = new int[26];
        Arrays.fill(indegree, 0);

        Set<Character> alphabet = new HashSet<>();
        Map<Character, Set<Character>> adjacencyListMap = new HashMap<>();

        for (String w : words) {
            for (char ch : w.toCharArray()) {
                alphabet.add(ch);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            // Prefix, can't extract edge
            if (w1.length() < w2.length() && w2.startsWith(w1)) continue;
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                // Invalid
                return "";
            };

            char[] e = extractEdge(w1, w2);
            if (e == null) {
                System.out.println("w1 = " + w1 + ", w2 = " + w2);
            }

            adjacencyListMap.putIfAbsent(e[0], new HashSet<>());
            if (!adjacencyListMap.get(e[0]).contains(e[1])) {
                adjacencyListMap.get(e[0]).add(e[1]);
                indegree[e[1] - 'a']++;
                // System.out.println(e[0] + " -> " + e[1]);
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (indegree[i] == 0 && alphabet.contains(ch)) {
                q.offer(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char current = q.poll();
            sb.append(current);
            // System.out.println("processing " + current);

            if (!adjacencyListMap.containsKey(current)) continue;
            for (char ch : adjacencyListMap.get(current)) {
                indegree[ch - 'a']--;
                if (indegree[ch - 'a'] == 0) {
                    q.offer(ch);
                }
            }
        }

        System.out.println(sb.toString());
        return sb.length() == alphabet.size() ? sb.toString() : "";
    }

    private char[] extractEdge(String w1, String w2) {
        int len1 = w1.length();
        int len2 = w2.length();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            char ch1 = w1.charAt(i);
            char ch2 = w2.charAt(i);
            if (ch1 != ch2) {
                return new char[] {ch1, ch2};
            }
        }

        return null;
    }
}
