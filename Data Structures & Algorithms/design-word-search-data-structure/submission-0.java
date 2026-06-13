class WordDictionary {
    private class TrieNode {
        private boolean isWord;
        private TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
               node.children[ch - 'a'] = new TrieNode(); 
            }
            node = node.children[ch - 'a'];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        return searchInternal(word, root);
    }

    private boolean searchInternal(String word, TrieNode root) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch != '.') {
                if (node.children[ch - 'a'] == null) {
                    return false;
                }
                node = node.children[ch - 'a'];
            } else {
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] == null) continue;

                    if (searchInternal(word.substring(i + 1), node.children[j])) {
                        return true;
                    }
                }

                return false;
            }
        }

        return true;
    }
}
