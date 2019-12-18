import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class AlienDictionary {

    class Graph {

        int v; // vertices
        LinkedList<Integer> adj[];
        boolean visited[];
        Stack<Integer> stack;

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for(int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }

            stack = new Stack<>();
            visited = new boolean[v];
            Arrays.fill(visited, false);

        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void topologicaSortUtil(int s) {

            visited[s] = true;

            for(int i=0; i<adj[s].size(); i++) {
                int neighbour = adj[s].get(i);
                if(!visited[neighbour]) {
                    topologicaSortUtil(neighbour);
                }
            }

            stack.push(s);
        }

        void topologicalSort() {

            for(int i=0; i<v; i++) {
                if(!visited[i]) {
                    topologicaSortUtil(i);
                }
            }

            while(!stack.isEmpty()) {
                System.out.print((char)(stack.pop()+'a') + " ");
            }

        }

        void alienDictionaryHelper(String[] input, int alphaSize) {

            //Graph g = new Graph(alphaSize);
            for(int i=0; i<input.length; i++) {
                for(int j=0; j<input[i].length()-1; j++) {
                    int source = input[i].charAt(j) - 'a';
                    int end = input[i].charAt(j+1) - 'a';

                    addEdge(source, end);
                }
            }

            topologicalSort();
        }
    }


    public void test() {
        String[] words = {"ccee", "cdbb", "bae", "aee", "daa"}; // alpha = 5 -> cdbae
        int aplhaSize = 5; // a,b,c,d,e

        Graph d = new Graph(5);
        d.alienDictionaryHelper(words, aplhaSize);




    }
}
