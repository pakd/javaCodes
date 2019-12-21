import java.util.Comparator;
import java.util.LinkedList;

public  class KruskalMST {


    class Subset {
        int parent;
        int rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    class Edge {
        int weight;
        int start;
        int end;

        public Edge(int start, int end, int weight) {

            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    class Graph {

        LinkedList<Subset> subset;
        LinkedList<Edge> edges = new LinkedList<>();
        int v;


        Graph(int v) {

            this.v = v;
            subset = new LinkedList<>();

            for(int i=0; i<v; i++) {
                subset.add(new Subset(i, 0) );
            }
        }



        void addEdge( int start, int end, int weight) {
            edges.add(new Edge( start, end, weight));
        }




        int find(int i) {
            if(i != subset.get(i).parent) {
                subset.get(i).parent = find(subset.get(i).parent);
            }

            return subset.get(i).parent;
        }

        void union(int x, int y) {

            int xRoot = find(x);
            int yRoot = find(y);

            // make yRoot parent
            if(subset.get(xRoot).rank >= subset.get(yRoot).rank)
            {
                subset.get(xRoot).parent = yRoot;
                subset.get(yRoot).rank++;
            }

            // make xRoot parent
            else if(subset.get(xRoot).rank < subset.get(yRoot).rank)
            {
                subset.get(yRoot).parent = xRoot;
                subset.get(xRoot).rank++;
            }

        }



        int findMST() {


            edges.sort(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.weight - o2.weight;
                }
            });

            for (Edge e : edges) {
                System.out.println(e.start + " " + e.end + " " + e.weight);
            }

            int mst_weight = 0;
            for(Edge e : edges) {
                int xRoot = find(e.start);
                int yRoot = find(e.end);

                if(xRoot == yRoot) {
                    continue;
                } else {
                    mst_weight += e.weight;
                    union(xRoot, yRoot);
                }
            }

            return mst_weight;
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


        System.out.println("mst_weight:" + g.findMST());

    }


}
