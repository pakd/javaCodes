import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

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
                System.out.print(stack.pop() + " ");
            }

        }

    }




    public void test() {

        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();

    }


}
