import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PhoneDirectory {

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


        void printDirectoryUtil(Trie node, String key) {

            if(node.isLeaf) {
                System.out.println(key);
            }

            for(Character x : node.children.keySet()) {
                key += x;
                printDirectoryUtil(node.children.get(x), key);
                key = key.substring(0, key.length()-1);
            }

        }

        void printDirectory(String key) {

            Trie curr = this;

            for(char x : key.toCharArray()) {
                if(curr.children.get(x) == null) {
                    System.out.println("----------");
                    return;
                }
                curr = curr.children.get(x);
            }
            printDirectoryUtil(curr, key);
        }




    }

    public void test() {
        String[] contacts = {"madan", "mohan", "mohanlal", "mohani", "sohan", "sara", "alan", "alanwest" };

        Trie trie = new Trie();


        for(String s : contacts) {
            trie.insert(s);
        }



        String key = "moh";
        // String key = "z";
        // String key = "s";
        // String key = "so";
        // String key = "alanw";
        // String key = "alan";
        trie.printDirectory(key);
    }
}
