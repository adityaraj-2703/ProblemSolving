package trie;

public class SumOfPrefixStoreofStrings {
    public int[] sumPrefixScores(String[] words) {
        root = new Trie();
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            addWord(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            ans[i] = calculateSum(words[i]);
        }
        return ans;
    }

    class Trie {
        Trie[] children;
        int count;

        Trie() {
            this.children = new Trie[26];
            this.count = 0;
        }

    }

    Trie root;

    public void addWord(String word) {
        Trie curr = root;
        if (curr == null) {
            System.out.println("tnull");
        }
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new Trie();
            }
            curr.children[word.charAt(i) - 'a'].count++;
            curr = curr.children[word.charAt(i) - 'a'];
        }
    }

    public int calculateSum(String word) {
        Trie curr = root;
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] != null) {
                sum += curr.children[word.charAt(i) - 'a'].count;
            }
            curr = curr.children[word.charAt(i) - 'a'];

        }
        return sum;
    }

    public static void main(String[] args) {
        String[] words = { "abc", "ab", "bc", "b" };
        SumOfPrefixStoreofStrings s = new SumOfPrefixStoreofStrings();
        int[] ans = s.sumPrefixScores(words);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
