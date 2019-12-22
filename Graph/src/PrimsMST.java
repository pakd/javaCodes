import java.sql.SQLOutput;
import java.util.*;

public class PrimsMST {
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
        Set<Integer> inMST;
        PriorityQueue<Node> pq;
        int[] dist;
        int[] parent;

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for(int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }

            inMST = new HashSet<>();

            pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.distance - o2.distance;
                }
            });

            parent = new int[v];
            Arrays.fill(parent, -1);

            dist = new int[v];
            Arrays.fill(dist, Integer.MAX_VALUE);


        }

        void addEdge(int v, int w, int weight) {
            adj[v].add(new Node(w, weight));
            adj[w].add(new Node(v, weight));
        }

        void Prims(int src) {
            dist[src] = 0;

            pq.add(new Node(src, 0));

            while(inMST.size() < v) {

                Node temp = pq.remove();
                inMST.add(temp.vertex);
                neighbourProcessing(temp.vertex);
            }

            printMST();
        }

        void neighbourProcessing(int u) {
            for(int i=0; i<adj[u].size(); i++) {
                Node neighbour = adj[u].get(i);

                if(!inMST.contains(neighbour.vertex)) {

                    if(dist[neighbour.vertex] > neighbour.distance) {
                        dist[neighbour.vertex] =  neighbour.distance;
                        parent[neighbour.vertex] = u;
                    }

                    pq.add(new Node(neighbour.vertex, dist[neighbour.vertex]));
                }

            }
        }

        void printMST() {
            System.out.println("Parent Matrix");
            for(int i=1; i<v; i++) {
                System.out.println(parent[i] + "->" + i);
            }
        }



    }
    public void test() {

        int V = 9;
        Graph g = new Graph(V);


        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.Prims(0);
    }
}
