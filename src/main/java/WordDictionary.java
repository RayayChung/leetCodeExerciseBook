//设计一个支持以下两种操作的数据结构：
//
// void addWord(word)
//bool search(word)
//
//
// search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
//
// 示例:
//
// addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
//
//
// 说明:
//
// 你可以假设所有单词都是由小写字母 a-z 组成的。
// Related Topics 设计 字典树 回溯算法


/**
 * Created on 2020/3/10.
 *
 * @author ray
 */
public class WordDictionary {

    private TreeNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || "".equals(word)) {
            return;
        }
        TreeNode node = root;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if (node.links[aChar - 'a'] == null) {
                TreeNode tmpNode = new TreeNode();
                node.links[aChar - 'a'] = tmpNode;
                node = tmpNode;
            } else {
                node = node.links[aChar - 'a'];
            }
        }
        node.isLeaf = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TreeNode tmp = root;
        return backtrack(word, tmp);
    }

    private boolean backtrack(String word, TreeNode tmp) {
        if (tmp == null) {
            return false;
        }
        if ("".equals(word)) {
            return tmp.isLeaf;
        }
        char ch = word.charAt(0);
        if ('.' != ch) {
            return backtrack(word.substring(1), tmp.links[ch - 'a']);
        }
        for (int j = 0; j < 26; j++) {
            if (tmp.links[j] != null) {
                if (backtrack(word.substring(1), tmp.links[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class TreeNode {

        private TreeNode[] links;

        private boolean isLeaf;

        public TreeNode() {
            isLeaf = false;
            this.links = new TreeNode[26];
        }

        public TreeNode[] getLinks() {
            return links;
        }

        public void setLinks(TreeNode[] links) {
            this.links = links;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean leaf) {
            isLeaf = leaf;
        }
    }

    public static void main(String[] args) {
        System.out.println("1".substring(1));
    }
}
