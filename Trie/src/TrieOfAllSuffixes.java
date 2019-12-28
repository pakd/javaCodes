import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TrieOfAllSuffixes {

    public class Trie {
        boolean isLeaf;
        LinkedList<Integer> list;
        Map<Character, Trie> children;

        Trie() {
            isLeaf = false;
            children = new HashMap<>();
            list = new LinkedList<>();
        }

        void insertWithPosition(String key, int position) {

            Trie curr = this;
            for (char x : key.toCharArray()) {
                if (curr.children.get(x) == null) {
                    curr.children.put(x, new Trie());
                }
                curr = curr.children.get(x);
                curr.list.add(position);

            }
            curr.isLeaf = true;
            curr.list.add(position);
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

        void search(String key) {
            System.out.println(key);
            Trie curr = this;
            for (char x : key.toCharArray()) {
                if (curr.children.get(x) == null) {
                    return;
                }
                curr = curr.children.get(x);
            }

            for(Integer x : curr.list) {
                System.out.print(x + " ");
            }
            System.out.println();

        }

        void insertAllSuffixesWithPosition(String str) {

            for(int i=0; i<str.length(); i++) {
                //System.out.println(str.substring(i) + " " + i);
                insertWithPosition(str.substring(i), i);
            }
        }

        void insertAllSuffixes(String str) {

            for(int i=0; i<str.length(); i++) {
                insert(str.substring(i));
            }
        }

        void countNodes(Trie node) {
            size++;
            for(Character x: node.children.keySet()) {
                countNodes(node.children.get(x));
            }
        }

    }

    int size = 0;

    public void testPatternSearch() {

        String txt = "geeksforgeeks.org";
        Trie root = new Trie();

        root.insertAllSuffixesWithPosition(txt);

        root.search("geek"); // 0, 8
        root.search("forgeeks"); // 5
        root.search("quiz"); // no where
        root.search("ee"); // 1 9
    }

    public void testCountDistinctSubstrings() {
        String str = "ababa";
        Trie root = new Trie();

        root.insertAllSuffixes(str);

        root.countNodes(root);
        System.out.println("Size :" + size);
    }
}
