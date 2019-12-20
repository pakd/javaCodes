import java.util.Arrays;
import java.util.LinkedList;

public class CycleInUndirectedGraph {

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
            adj[w].add(v);
        }

        boolean isCycleDFS(int s, int parent) {

            System.out.println(s + "    " +parent);
            visited[s] = true;

            for(int i=0; i<adj[s].size(); i++) {
                int neighbour = adj[s].get(i);
                if(!visited[neighbour]) {
                    if(isCycleDFS(neighbour, s)) {
                        return true;
                    }
                } else if(neighbour != parent) {
                    return true;
                }
            }

            return false;
        }

        boolean checkCycle() {
            for(int i=0; i<v; i++) {

                if(!visited[i]) {
                    if(isCycleDFS(i, -1)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }


    public void test() {

        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4 );
        System.out.println(g1.checkCycle());
    }
}
