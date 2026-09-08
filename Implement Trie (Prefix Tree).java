class Trie {
    private static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isEndOfWord = false;
    }
    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }   node = node.children[index];
        } node.isEndOfWord = true;
    }
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEndOfWord;
    }
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }
    private TrieNode findNode(String str) {
        TrieNode node = root;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }  node = node.children[index];
        }return node;
    }}
