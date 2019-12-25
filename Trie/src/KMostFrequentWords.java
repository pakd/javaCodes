import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentWords {

    public class Node {
        int frequency;
        String word;

        public Node(int frequency, String word) {
            this.frequency = frequency;
            this.word = word;
        }
    }

    public class Trie {
        boolean isLeaf;
        Map<Character, Trie> children;
        int frequency = 0;

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
            curr.frequency++;
        }

        void getAllWords(Trie node, String prefix) {
            if(node == null) {
                return;
            }
            if(node.isLeaf) {
                pq.add(new Node(node.frequency, prefix));
            }

            for(Character x :node.children.keySet()) {
                getAllWords(node.children.get(x), prefix + x);
            }

        }


    }

    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.frequency - o1.frequency;
        }
    });

    public void test() {

        String book = "Welcome to the world of Geeks This portal has been created to provide well written well thought" +
                " and well explained solutions for selected questions If you like Geeks for Geeks and would like to contribute" +
                " here is your chance You can write article and mail your article to contribute at geeksforgeeks org See your" +
                " article appearing on the Geeks for Geeks main page and help thousands of other Geeks";
        String words[] = book.split(" ");

        Trie root = new Trie();
        for(String x : words) {
            root.insert(x);
        }

        root.getAllWords(root, "");
        int k = 5;



//        System.out.println(pq.size());
        while(k-- > 0 && !pq.isEmpty()) {
            Node temp = pq.remove();
            System.out.println(temp.word + "=" + temp.frequency);
        }


    }
}
