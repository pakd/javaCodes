import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Boggle {

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


        int R = 3;
        int C = 3;
        boolean isSafe(int i, int j, boolean[][] visited) {
            if(i >= 0 && i<R && j>=0 && j<C && visited[i][j] == false) {
                return true;
            }
            return false;
        }
        /*
        *       n
        * e            w
        *       s
        */
        void solveBoggleUtil(char[][] boggle, boolean[][] visited, String prefix, Trie node, int i, int j) {
            visited[i][j] = true;

            if(node.isLeaf) {
                System.out.println(prefix);
            }

            // n
            if(isSafe(i-1, j, visited) && (node.children.get(boggle[i-1][j]) != null)) {
                solveBoggleUtil(boggle, visited, prefix + boggle[i-1][j], node.children.get(boggle[i-1][j]), i-1, j);
            }


            // ne
            if(isSafe(i-1, j-1, visited) && (node.children.get(boggle[i-1][j-1]) != null)) {
                solveBoggleUtil(boggle, visited, prefix + boggle[i-1][j-1], node.children.get(boggle[i-1][j-1]), i-1, j-1);
            }

            // e
            if(isSafe(i, j-1, visited) && (node.children.get(boggle[i][j-1]) != null)) {
                solveBoggleUtil(boggle, visited, prefix + boggle[i][j-1], node.children.get(boggle[i][j-1]), i, j-1);
            }

            // es
            if(isSafe(i+1, j-1, visited) && (node.children.get(boggle[i+1][j-1]) != null)) {
                solveBoggleUtil(boggle, visited, prefix + boggle[i+1][j-1], node.children.get(boggle[i+1][j-1]), i+1, j-1);
            }

            // s
            if(isSafe(i+1, j, visited) && (node.children.get(boggle[i+1][j]) != null)) {
                solveBoggleUtil(boggle, visited, prefix + boggle[i+1][j], node.children.get(boggle[i+1][j]), i+1, j);
            }

            // sw
            if(isSafe(i+1, j+1, visited) && (node.children.get(boggle[i+1][j+1]) != null)) {
                solveBoggleUtil(boggle, visited, prefix + boggle[i+1][j+1], node.children.get(boggle[i+1][j+1]), i+1, j+1);
            }

            // w
            if(isSafe(i, j+1, visited) && (node.children.get(boggle[i][j+1]) != null)) {
                solveBoggleUtil(boggle, visited, prefix + boggle[i][j+1], node.children.get(boggle[i][j+1]), i, j+1);
            }

            // wn
            if(isSafe(i-1, j+1, visited) && (node.children.get(boggle[i-1][j+1]) != null)) {
                solveBoggleUtil(boggle, visited, prefix + boggle[i-1][j+1], node.children.get(boggle[i-1][j+1]), i-1, j+1);
            }

            visited[i][j] = false;
        }

        void solveBoggle(char[][] boggle) {

            Trie curr = this;
            int r = boggle.length;
            int c = boggle[0].length;

            boolean[][] visited = new boolean[r][c];
            for(int i=0; i<r; i++) {
                Arrays.fill(visited[0], false);
            }

            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    String prefix = "";
                    if(curr.children.get(boggle[i][j]) != null) {

                        solveBoggleUtil(boggle, visited, prefix + boggle[i][j], curr.children.get(boggle[i][j]), i, j);
                    }
                }
            }


        }
    }

    public void test() {

        String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GEE"};
        char[][] boggle =
        {
            {'G','I','Z'},
            {'U','E','K'},
            {'Q','S','E'}
        };



        Trie root = new Trie();

        for(String x : dictionary) {
            root.insert(x);
        }

        root.solveBoggle(boggle);
    }
}
