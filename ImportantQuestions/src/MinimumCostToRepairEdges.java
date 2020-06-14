import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumCostToRepairEdges {


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

        List<Subset> subset;
        List<Edge> edges = new LinkedList<>();
        int v;


        Graph(int v) {

            this.v = v;
            subset = new LinkedList<>();

            for (int i = 0; i < v; i++) {
                subset.add(new Subset(i, 0));
            }
        }


        void addEdge(int start, int end, int weight) {
            edges.add(new Edge(start, end, weight));
        }


        int find(int i) {
            if (i != subset.get(i).parent) {
                subset.get(i).parent = find(subset.get(i).parent);
            }

            return subset.get(i).parent;
        }

        void union(int x, int y) {

            int xRoot = find(x);
            int yRoot = find(y);

            // make yRoot parent
            if (subset.get(xRoot).rank >= subset.get(yRoot).rank) {
                subset.get(xRoot).parent = yRoot;
                subset.get(yRoot).rank++;
            }

            // make xRoot parent
            else if (subset.get(xRoot).rank < subset.get(yRoot).rank) {
                subset.get(yRoot).parent = xRoot;
                subset.get(xRoot).rank++;
            }

        }


        int findMST() {


            edges.sort((a, b) -> a.weight - b.weight);

            for (Edge e : edges) {
                System.out.println(e.start + " " + e.end + " " + e.weight);
            }

            int mst_weight = 0;
            for (Edge e : edges) {
                int xRoot = find(e.start);
                int yRoot = find(e.end);

                if (xRoot == yRoot) {
                    continue;
                } else {
                    mst_weight += e.weight;
                    union(xRoot, yRoot);
                }
            }

            return mst_weight;
        }

    }

    public int encode (int i, int j) {
        return i*10 + j;
    }


    public void testMinimumCostToRepairEdges(int[][] edges, int[][] edgesToRepair) {


        Map<Integer, Integer> map = new HashMap<>();

        for (int[] x : edges) {
            map.put(encode(x[0], x[1]), 0);
        }

        for (int[] x : edgesToRepair) {
            map.put(encode(x[0], x[1]), x[2]);
        }


        Graph g = new Graph(map.size());

        for (Integer x : map.keySet()) {
            int first = x/10;
            int second = x%10;

            int weight = map.get(x);

            g.addEdge(first, second, weight);


        }
        System.out.println(g.findMST());
    }

    public MinimumCostToRepairEdges() {

        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 4}}, edgesToRepair1 = {{0, 1, 12}, {2, 3, 30}, {0, 4, 8}}; // ans = 20
        testMinimumCostToRepairEdges(edges1, edgesToRepair1);

        int[][] edges2 = {{0, 1}, {1, 2}, {3, 4}, {2, 4}, {0, 5}, {1, 3}}, edgesToRepair2 = {{0, 5, 410}, {1, 3, 800}}; // ans = 410

        testMinimumCostToRepairEdges(edges2, edgesToRepair2);

        int[][] edges3 = {{0, 1}, {1, 2}, {3, 4}, {4, 5}, {0, 4}, {1, 3}, {2, 3}}, edgesToRepair3 = {{0, 4, 110}, {1, 3, 84}, {2, 3, 79}}; // ans = 79

        testMinimumCostToRepairEdges(edges3, edgesToRepair3);
    }

}
