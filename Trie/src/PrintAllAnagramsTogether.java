import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PrintAllAnagramsTogether {



    public class Trie {
        boolean isLeaf;

        Map<Character, Trie> children;
        LinkedList<String> list = new LinkedList<>();

        Trie() {
            isLeaf = false;
            children = new HashMap<>();
        }

        void insert(String key, String unSortedKey) {
            System.out.println("Inserting " + key + ", " + unSortedKey);
            Trie curr = this;
            for (char x : key.toCharArray()) {
                if (curr.children.get(x) == null) {
                    curr.children.put(x, new Trie());
                }
                curr = curr.children.get(x);
            }
            curr.isLeaf = true;
            curr.list.add(unSortedKey);
        }


        void printAnagram(Trie node) {

            if(node.isLeaf) {
                for(String s : node.list) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }

            for(Character c : node.children.keySet()) {
                printAnagram(node.children.get(c));
            }
        }




    }
    String sortString(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    public void test() {

        String[] wordArr = {"cat", "dog", "tac", "god", "act", "gdo"};


        Trie trie = new Trie();
        for(int i=0; i<wordArr.length; i++) {
            String copyString = wordArr[i];
            String sorted = sortString(copyString);
            trie.insert(sorted, copyString);

        }

        trie.printAnagram(trie);

    }
}
