import java.util.Arrays;
import java.util.LinkedList;

public class CycleInDirectedGraph {

    enum COLORS {
        White,
        Gray,
        Black
    }

    class Graph {

        int v; // vertices
        LinkedList<Integer> adj[];
        COLORS[] colors;


        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for(int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }
            colors = new COLORS[v];

            Arrays.fill(colors, COLORS.White);

        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        boolean isCycleDFS(int s) {


            colors[s] = COLORS.Gray;

            for (int i = 0; i < adj[s].size(); i++) {
                int neighbour = adj[s].get(i);

                if (colors[neighbour] == COLORS.Gray) {
                    return true;
                } else if (colors[neighbour] == COLORS.Black) {
                    // already explored
                    continue;
                }
                else if(colors[neighbour] == COLORS.White && isCycleDFS(neighbour)) {
                    return true;
                }
            }
            colors[s] = COLORS.Black;
            return false;

        }

        boolean checkCycle() {

            for(int i=0; i<v; i++) {

                if(colors[i] == COLORS.White) {
                    if(isCycleDFS(i)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }


    public void test() {

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(3, 0);
        System.out.println(g2.checkCycle());
    }
}
