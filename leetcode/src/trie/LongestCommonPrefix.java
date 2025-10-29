package trie;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Trie t = new Trie();
        int min = Integer.MAX_VALUE;
        String word = "";
        for (int i = 0; i < strs.length; i++) {
            if (min > strs[i].length()) {
                word = strs[i];
                min = strs[i].length();
            }
            addWord(t, strs[i]);
        }
        return check(t, strs.length, word);
    }

    public void addWord(Trie t, String word) {
        Trie curr = t;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new Trie();

            }
            curr.children[word.charAt(i) - 'a'].count++;
            curr = curr.children[word.charAt(i) - 'a'];

        }
    }

    public String check(Trie t, int length, String word) {
        Trie curr = t;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (curr != null && curr.children[word.charAt(i) - 'a'].count == length) {
                sb.append(word.charAt(i));
                curr = curr.children[word.charAt(i) - 'a'];
            } else {
                return sb.toString();
            }

        }
        return sb.toString();

    }

    class Trie {
        Trie[] children;
        int count;

        Trie() {
            this.children = new Trie[26];
            this.count = 0;
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(obj.longestCommonPrefix(strs));
    }

}
