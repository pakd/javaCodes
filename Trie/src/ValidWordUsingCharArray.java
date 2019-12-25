import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordUsingCharArray {


    public class Trie {
        boolean isLeaf;

        Map<Character, Trie> children;

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


        void findValidWordsUtil(Trie node, Set<Character> set, String prefix) {

            if(node.isLeaf) {
                System.out.println(prefix);
            }

            for(Character x : node.children.keySet()) {
                if(set.contains(x)) {
                    findValidWordsUtil(node.children.get(x), set, prefix + x);
                }
            }
        }


        void findValidWords(char[] arr) {
            Trie curr = this;

            Set<Character> set = new HashSet<>();

            for(char x : arr) {
                set.add(x);
            }

            String prefix = "";
            for(char x : arr) {
                if(curr.children.get(x) != null) {
                    prefix += x;
                    findValidWordsUtil(curr.children.get(x), set, prefix);
                }
                prefix = "";
            }
        }
    }

    public void test() {


        String[] words = { "go", "bat", "me", "eat", "goal", "boy", "run"};

        Trie root = new Trie();

        for(String x : words) {
            root.insert(x);
        }

        char[] arr =  {'e', 'o', 'b', 'a', 'm', 'g', 'l'};

        root.findValidWords(arr);
    }
}
