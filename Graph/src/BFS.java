import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    class Graph {

        int v; // vertices
        LinkedList<Integer> adj[];

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for(int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void BFSearch(int s) {

            boolean[] visited = new boolean[v];
            Arrays.fill(visited, false);

            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            visited[s] = true;


            while(!q.isEmpty()) {

                int temp = q.remove();
                System.out.print(temp + " ");

                for(int i=0; i<adj[temp].size(); i++) {
                    int neighbour = adj[temp].get(i);
                    if(!visited[neighbour]) {
                        visited[neighbour] = true;
                        q.add(adj[temp].get(i));
                    }
                }
            }
        }

    }




    public void test() {

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFSearch(2);

    }
}
