class Solution {
    private class TrieNode {
        private List<Integer> wordIndice = new ArrayList<>();
        private TrieNode[] children = new TrieNode[26];
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (char ch : words[i].toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }

            node.wordIndice.add(i);
        }

        int m = board.length;
        int n = board[0].length;

        Set<String> ans = new LinkedHashSet<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visit(words, board, m, n, i, j, root, visited, ans);
            }
        }

        return new ArrayList<>(ans);
    }

    private void visit(String[] words, char[][] board, int m, int n, 
      int row, int col, TrieNode node, boolean[][] visited, Set<String> ans) {
        if (!node.wordIndice.isEmpty()) {
            for (int idx : node.wordIndice) {
                ans.add(words[idx]);
            }
            node.wordIndice.clear();
        }

        if (row < 0 || row >= m || col < 0 || col >= n || 
            node.children[board[row][col] - 'a'] == null ||
            visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dirs) {
            int nextRow = row + d[0];
            int nextCol = col + d[1];
            visit(words, board, m, n, nextRow, nextCol, node.children[board[row][col] - 'a'], 
                  visited, ans);
        }

        visited[row][col] = false;
    }
}
