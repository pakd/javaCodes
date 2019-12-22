import java.util.*;

public class DijkstraAlgoForShortestPath {

    class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    class Graph {
        int v; // vertices
        LinkedList<Node> adj[];
        boolean visited[];

        // Dijkstra related variables
        Set<Integer> settled;
        PriorityQueue<Node> pq;
        int[] dist;

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for(int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }

            settled = new HashSet<>();

            pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.distance - o2.distance;
                }
            });

            dist = new int[v];
            Arrays.fill(dist, Integer.MAX_VALUE);
        }

        void addEdge(int v, int w, int weight) {
            adj[v].add(new Node(w, weight));
        }

        void Dijkstra(int src) {
            dist[src] = 0;

            pq.add(new Node(src, 0));

            while(settled.size() < v) {

                Node temp = pq.remove();
                settled.add(temp.vertex);
                neighbourProcessing(temp.vertex);
            }

            printDistMatrix();
        }

        void neighbourProcessing(int u) {
            for(int i=0; i<adj[u].size(); i++) {
                Node neighbour = adj[u].get(i);

                if(!settled.contains(neighbour.vertex)) {

                    if(dist[neighbour.vertex] > dist[u] + neighbour.distance) {
                        dist[neighbour.vertex] = dist[u] + neighbour.distance;
                    }

                    pq.add(new Node(neighbour.vertex, dist[neighbour.vertex]));
                }

            }
        }

        void printDistMatrix() {
            for(int i=0; i<v; i++) {
                System.out.println(i + " " + dist[i]);
            }
        }



    }

    public void test() {
        Graph g = new Graph(5);

        g.addEdge(0, 1, 9);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(0, 4, 3);
        g.addEdge(2,1 ,2);
        g.addEdge(2,3, 4);

        g.Dijkstra(0);

    }
}
