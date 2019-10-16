import java.util.HashMap;
import java.util.Map;

public class Trie {
    boolean isLeaf;

    Map<Character, Trie> children;

    Trie() {
        isLeaf = false;
        children = new HashMap<>();
    }

    void insert(String key) {
        Trie curr = this;
        for(char x : key.toCharArray()) {
            if(curr.children.get(x) == null) {
                curr.children.put(x, new Trie());
            }
            curr = curr.children.get(x);
        }
        curr.isLeaf = true;
    }

    boolean search(String key) {
        Trie curr = this;
        for (char x : key.toCharArray()) {
            if(curr.children.get(x) == null) {
                return false;
            }
            curr = curr.children.get(x);
        }
        return curr.isLeaf;
    }

    public void test_trie_basics() {
        Trie t = new Trie();
        t.insert("deepak");
        t.insert("pakd");
        t.insert("dpk");
        t.insert("deep");
        t.insert("deepu");

        System.out.println(t.search("deepak"));
        System.out.println(t.search("deep"));
        System.out.println(t.search("dee"));
        System.out.println(t.search("deepu"));

    }
}
