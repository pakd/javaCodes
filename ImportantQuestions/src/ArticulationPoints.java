import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArticulationPoints {



    List<List<Integer>> result = new ArrayList<>();

    // timestamp
    int ts = 0;
    int outEdgeCount = 0;

    class Graph {

        int v; // vertices
        LinkedList<Integer> adj[];
        boolean[] visited;

        // lowest id that can be reached from current node including current node.
        int[] lowLink;

        // time of discovery
        int[] discoveredId;

        boolean[] isArt;

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for(int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }
            visited = new boolean[v];
            Arrays.fill(visited, false);

            isArt = new boolean[v];
            Arrays.fill(isArt, false);

            lowLink = new int[v];
            discoveredId = new int[v];

        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        void findArtiPoints() {
            for(int i=0; i<v; i++) {

                if(!visited[i]) {
                    outEdgeCount = 0;
                    DFSTarjan(i, i, -1);
                    isArt[i] = (outEdgeCount > 1)? true:false;
                }
            }
        }

        void DFSTarjan(int root, int currNode, int parent) {
            if(root == parent) {
                outEdgeCount++;
            }

            visited[currNode] = true;
            ++ts;
            discoveredId[currNode] = lowLink[currNode] = ts;

            for(int neighbour : adj[currNode]) {

                // if going back to parent, just ignore
                if(neighbour == parent) {
                    continue;
                }

                if(!visited[neighbour]) {
                    DFSTarjan(root, neighbour, currNode);

                    //coming back in recursion, if possible to decrease lowLink value of currNode
                    lowLink[currNode] = Math.min(lowLink[currNode], lowLink[neighbour]);

                    // for getting bridges
                    // this is the definition of bridge/articulation point
                    if(discoveredId[currNode] <= lowLink[neighbour]) {
                        isArt[currNode] = true;
                    }



                } else {

                    // if already visited, but neighbour discoveredId is low, like in case of cycle e.g. 5 ->6 ->7 ->5 (7 to 5)
                    lowLink[currNode] = Math.min(lowLink[currNode], discoveredId[neighbour]);
                }



            }

        }

    }

    ArticulationPoints() {

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3},
                {2, 5},
                {5, 6},
                {3, 4}
        };

        findArticulationPoints(7, edges);
    }



    public void findArticulationPoints(int n, int[][] connections) {
        Graph g = new Graph(n);

        for (int[] x : connections) {
            int node1 = x[0];
            int node2 = x[1];

            g.addEdge(node1, node2);
        }

        g.findArtiPoints();

        for(int i=0; i<g.v; i++) {
            if(g.isArt[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
