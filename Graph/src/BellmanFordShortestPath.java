import java.util.Arrays;
import java.util.LinkedList;

public class BellmanFordShortestPath {

    class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    class Graph {

        int v; // vertices
        int[] dist;
        LinkedList<Edge> edges;



        Graph(int v) {
            this.v = v;
            dist = new int[v];
            // Step 1: Initialize distances from src to all other vertices
            // as INFINITE
            Arrays.fill(dist, Integer.MAX_VALUE);
            edges = new LinkedList<>();

        }

        void addEdge(int start, int end, int weight) {
            edges.add(new Edge(start, end, weight));
        }

        void bellmanFord(int src) {

            dist[src] = 0;

            // Step 2: Relax all edges |V| - 1 times. A simple shortest
            // path from src to any other vertex can have at-most |V| - 1
            // edges
            for(int i=1; i<=v-1; i++) {
                for(Edge e : edges) {
                    int u = e.start;
                    int v = e.end;
                    int weight = e.weight;
                    if(dist[u]!=Integer.MAX_VALUE &&  dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }


            // Step 3: check for negative-weight cycles.  The above step
            // guarantees shortest distances if graph doesn't contain
            // negative weight cycle.  If we get a shorter path, then there
            // is a cycle.
            for(Edge e : edges) {
                int u = e.start;
                int v = e.end;
                int weight = e.weight;
                if(dist[u]!=Integer.MAX_VALUE &&  dist[u] + weight < dist[v]) {

                    System.out.println("negative cycle exists");
                    return;
                }
            }

            printArr();

        }

        void printArr()
        {
            System.out.println("Vertex   Distance from Source");
            for (int i = 0; i < v; ++i)
            {
                System.out.println(i + " " + dist[i]);
            }
        }



    }
    public void test() {
        int V = 5;
        Graph g = new Graph(V);

        g.addEdge(0, 1, -1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 4, 2);
        g.addEdge(3, 2, 5);
        g.addEdge(3, 1, 1);
        g.addEdge(4, 3, -3); // g.addEdge(4, 3, -4); --> for negative cycle

        g.bellmanFord(0);
    }
}
