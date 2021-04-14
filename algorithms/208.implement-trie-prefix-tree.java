/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
    
    Trie[] next = new Trie[26];
    boolean end = false;

    /** Initialize your data structure here. */
    public Trie() {

    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(int i=0; i< word.length(); i++) {
            int nextIndex = (int)(word.charAt(i)-'a');
            if (node.next[nextIndex] == null) {
                node.next[nextIndex] = new Trie();
            }
            node = node.next[nextIndex];
        }
        node.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for(int i=0; i< word.length(); i++) {
            node = node.next[word.charAt(i)-'a'];
            if (node == null) {
                return false;
            }
        }
        return node.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for(int i=0; i< prefix.length(); i++) {
            node = node.next[prefix.charAt(i)-'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

