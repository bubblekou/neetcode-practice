class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> parents = new HashMap<>();
        for (String w : wordList) {
            char[] chs = w.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char savedChar = chs[i];
                chs[i] = '*';
                String replaceWord = new String(chs);
                parents.putIfAbsent(replaceWord, new ArrayList<>());
                parents.get(replaceWord).add(w);
                chs[i] = savedChar;
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String word = q.poll();
                visited.add(word);
                if (endWord.equals(word)) {
                    return res;
                }

                char[] chs = word.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char savedChar = chs[j];
                    chs[j] = '*';
                    String wildWord = new String(chs);
                    if (!parents.containsKey(wildWord)) continue;
                    for (String next : parents.get(wildWord)) {
                        if (visited.contains(next)) continue;
                        q.offer(next);
                    }
                    chs[j] = savedChar;

                }
            }

            res++;
        } 

        return 0;       
    }
}
