import java.awt.geom.Line2D;
import java.util.LinkedList;

public class UnionFindRankCycle {

    class Subset {
        int parent;
        int rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    class Edge {
        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class Graph {
        int v;
        Graph(int v) {
            subset = new LinkedList<>();

            for(int i=0; i<v; i++) {
                subset.add(new Subset(i, 0));
            }
        }

        LinkedList<Edge> edges = new LinkedList<>();

        void addEdge(int start, int end) {
            edges.add(new Edge(start, end));
        }

        LinkedList<Subset> subset;


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

        boolean isCycle() {

            for(Edge i : edges)
            {
                int x = find(i.start);
                int y = find(i.end);

                System.out.println(x + " " + y);

                if(x == y)
                {
                    return true;
                }
                union(x, y);
            }
            return false;
        }



        }


    public void test() {
        Graph g = new Graph(3);
        g.addEdge(0,1);
        g.addEdge(1, 2);
        //g.addEdge(0, 2); // comment to convert it to acyclic


        System.out.println(g.isCycle());

    }
}
