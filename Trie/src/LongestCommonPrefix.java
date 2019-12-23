import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    public class Trie {
        boolean isLeaf;

        Map<Character,Trie> children;

        Trie() {
            isLeaf = false;
            children = new HashMap<>();
        }

        void insert(String key) {
            Trie curr = this;
            for (char x : key.toCharArray()) {
                if (curr.children.get(x) == null) {
                    curr.children.put(x, new Trie());
                }
                curr = curr.children.get(x);
            }
            curr.isLeaf = true;
        }

        void printLongestCommonPrefix(String key) {
            String ans = "";
            Trie curr = this;
            for(char x : key.toCharArray()) {
                if(curr.children.size() > 1) {
                    System.out.println(ans);
                    return;
                } else {
                    curr = curr.children.get(x);
                    ans += x;
                }
            }
        }


    }
    public void test() {

        String[] words = {"geeksforgeeks", "geeks", "geek", "geekzer"}; // ans = "gee"
        Trie trie = new Trie();
        for(String x : words) {
            trie.insert(x);
        }
        trie.printLongestCommonPrefix(words[0]);


    }
}
