import java.util.HashMap;
import java.util.Map;

public class FindLongestPrefix {


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


         String findLongestPrefix(String str) {

            Trie curr = this;

            String temp = "";
            String ans = "";

            for(char x : str.toCharArray()) {
                if(curr.children.get(x) == null) {
                    return ans;
                }
                curr = curr.children.get(x);
                temp += x;
                if(curr.isLeaf) {
                    ans = temp;
                }
            }
             return ans;
         }



    }

    public void test() {

        String[] words = {"are", "area", "base", "cat", "cater", "children", "basement"};
        Trie trie = new Trie();
        for(String x : words) {
            trie.insert(x);
        }

        String[] wordsCheck = {"caterer", "basement", "are", "arex", "basemexz", "xyx", "catex"};
        for(String x : wordsCheck) {
            System.out.println(x +  " : " +  trie.findLongestPrefix(x));
        }
    }
}
