import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WeightedSearch {

    public class Node {
        String str;
        int weight;

        public Node(String str, int weight) {
            this.str = str;
            this.weight = weight;
        }
    }

    public class Trie {
        boolean isLeaf;
        Map<Character, Trie> children;
        int weight;

        Trie() {
            isLeaf = false;
            children = new HashMap<>();
        }

        void insert(String key, int w) {
            Trie curr = this;
            for (char x : key.toCharArray()) {
                if (curr.children.get(x) == null) {
                    curr.children.put(x, new Trie());
                }
                curr = curr.children.get(x);
            }
            curr.isLeaf = true;
            curr.weight = w;
        }



        void weightSearchUtil(Trie node, String pre) {

            if(node == null) {
                return;
            }

            if(node.isLeaf) {
                if(node.weight > w) {
                    w = node.weight;
                    ans = pre;
                }
            }

            for(Character t : node.children.keySet()) {
                weightSearchUtil(node.children.get(t), pre + t);
            }

        }

        void weightedSearch(String pre) {

            Trie curr = this;
            for(char x : pre.toCharArray()) {
                if(curr.children.get(x) == null) {
                    return;
                }
                curr = curr.children.get(x);
            }


            weightSearchUtil(curr, pre);
            System.out.println("string: " + ans);
            System.out.println("w: " + w);
        }



    }

    public static int w = 0;
    public static String ans =  "";

    public void test() {
        LinkedList<Node> list = new LinkedList<>();
        list.add(new Node("geeks", 15));
        list.add(new Node("geeksfor", 30));
        list.add(new Node("geeksforgeeks", 45));

        Trie trie = new Trie();
        for (Node x : list) {
            trie.insert(x.str, x.weight);
        }
        trie.weightedSearch("geek");
    }
}
