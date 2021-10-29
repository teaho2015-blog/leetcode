package net.teaho.algorhythm.leetcode.alg208;

/**
 *
 * <p>208. 实现 Trie (前缀树)
 * <p>https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 *
 * <p>执行用时： 31 ms , 在所有 Java 提交中击败了 94.52% 的用户
 * <p>内存消耗： 48.9 MB , 在所有 Java 提交中击败了 31.72% 的用户
 *
 * @author teaho2015@gmail.com
 * @date 2021-09
 * @since 1.0.0
 */
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode(0, 0);
    }
    
    public void insert(String word) {
        if (word.length() == 0) {
            return;
        }

        TrieNode cursor = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (cursor.nextNode[chars[i] - 'a'] == null) {
                cursor.nextNode[chars[i] - 'a'] = new TrieNode(0, 0);
            }
            cursor = cursor.nextNode[chars[i] - 'a'];
            cursor.prefix++;
        }
        cursor.count++;
    }
    
    public boolean search(String word) {
        if (word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode cursor = root;
        for (int i = 0; i < chars.length; i++) {
            if (cursor.nextNode[chars[i] - 'a'] == null) {
                return false;
            }
            cursor = cursor.nextNode[chars[i] - 'a'];
        }
        return cursor.count > 0;
    }
    
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode cursor = root;
        for (int i = 0; i < chars.length; i++) {
            if (cursor.nextNode[chars[i] - 'a'] == null) {
                return false;
            }
            cursor = cursor.nextNode[chars[i] - 'a'];
        }
        return cursor.prefix > 0;

    }

    public static class TrieNode {
        /**
         * 有多少单词以该节点结尾
         */
        int count;
        /**
         * 有多少单词前缀是该节点
         */
        int prefix;

        TrieNode[] nextNode = new TrieNode[26];

        public TrieNode(int count, int prefix) {
            this.count = count;
            this.prefix = prefix;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */