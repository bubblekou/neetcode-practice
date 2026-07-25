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
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            TrieNode node = trie.root;
            int j = i;
            while (j < n && node != null) {
                node = node.children[s.charAt(j) - 'a'];
                if (node != null && node.isWord) {
                    dp[j + 1] = Math.min(dp[j + 1], dp[i]);
                }
                j++;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + i - j);
            }
        }
        // System.out.println(Arrays.toString(dp));
        
        return dp[n];
    }
}