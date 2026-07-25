class TrieNode {
    private TrieNode[] children;
    private boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root = new TrieNode();

    public Trie() {
        this.root = new TrieNode();
    }

    public void addWord(String w) {
        TrieNode node = root;
        for (char c : w.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();
        for (String w : dictionary) {
           trie.addWord(w); 
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return dfs(0, s, trie, dp);
    }

    private int dfs(int i, String s, Trie trie, int[] dp) {
        if (i == s.length()) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int res = 1 + dfs(i + 1, s, trie, dp);
        TrieNode curr = trie.root;
        for (int j = i; j < s.length(); j++) {
            if (curr.children[s.charAt(j) - 'a'] == null) {
                break;
            }
            curr = curr.children[s.charAt(j) - 'a'];
            if (curr.isWord) {
                res = Math.min(res, dfs(j + 1, s, trie, dp));
            }
        }

        dp[i] = res;
        return res;
    }
}