import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
    class Graph {

        int v; // vertices
        LinkedList<Integer> adj[];
        boolean visited[];

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for(int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }
            visited = new boolean[v];
            Arrays.fill(visited, false);

        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void DFSearch(int s) {

            System.out.print(s + " ");
            visited[s] = true;

            for(int i=0; i<adj[s].size(); i++) {
                int neighbour = adj[s].get(i);
                if(!visited[neighbour]) {
                    DFSearch(neighbour);
                }
            }

        }

    }




    public void test() {

        Graph g = new Graph(6);

        g.addEdge(2, 0);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 5);
        g.addEdge(1, 4); // DFS : 2 0 1 5 4 3

        g.DFSearch(2);

    }
}
