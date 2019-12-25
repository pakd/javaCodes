import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static java.lang.Character.isUpperCase;

public class PrintPatternUsingCamelCaseQuery {


    public class Trie {
        boolean isLeaf;
        Map<Character, Trie> children;
        LinkedList<String> list = new LinkedList<>();

        Trie() {
            isLeaf = false;
            children = new HashMap<>();
        }

        void insert(String key) {
            Trie curr = this;
            for (char x : key.toCharArray()) {

                if(isUpperCase(x))
                {
                    if (curr.children.get(x) == null) {
                        curr.children.put(x, new Trie());
                    }
                    curr = curr.children.get(x);
                }

            }
            curr.isLeaf = true;
            curr.list.add(key);
        }

        void recursiveSearch(Trie node, String pre) {
            if(node.isLeaf) {
                for(String x : node.list) {
                    System.out.println(x);
                }
            }

            for(Character x : node.children.keySet()) {
                recursiveSearch(node.children.get(x), pre + x);
            }
        }

        void CCSearch(String pre) {
            Trie curr = this;

            for(char x : pre.toCharArray()) {
                if(curr.children.get(x) == null) {
                    return;
                }
                curr = curr.children.get(x);
            }

            recursiveSearch(curr, pre);
        }


    }

    public void test() {

        String[] dict = {"Hi", "Hello", "HelloWorld",  "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab" };
        Trie root = new Trie();


        for(String x : dict) {
            root.insert(x);
        }

        root.CCSearch("HT");

        System.out.println();

        root.CCSearch("H");
    }
}
