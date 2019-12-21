import java.rmi.dgc.DGC;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class KosarajuSCCAlgorithm {

    class Graph {

        int v;
        LinkedList<Integer> adj[];
        LinkedList<Integer> adjT[];
        boolean[] visited;
        Stack<Integer> stack;

        Graph(int v) {
            this.v = v;

            visited = new boolean[v];
            Arrays.fill(visited, false);


            adj = new LinkedList[v];
            adjT = new LinkedList[v];

            for(int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
                adjT[i] = new LinkedList<>();

            }

        }

        void addEdge(int v, int w) {
            adj[v].add(w);;
        }

        void DFSUtil(int s) {
            visited[s] = true;

            for(int i=0; i<adj[s].size(); i++) {
                int neighbour = adj[s].get(i);

                if(!visited[neighbour]) {
                    DFSUtil(neighbour);
                }
            }

            stack.push(s);

        }
        void DFSUtilAfterTranspose(int s) {
            visited[s] = true;
            System.out.print(s + " ");

            for(int i=0; i<adjT[s].size(); i++) {
                int neighbour = adjT[s].get(i);
                if(!visited[neighbour]) {
                    DFSUtilAfterTranspose(neighbour);
                }
            }
        }

        void findSCC() {
            stack = new Stack<>();

            for(int i=0; i<v; i++) {
                if(!visited[i]) {
                    DFSUtil(i);
                }
            }

            System.out.println(stack);

            transpose();
            Arrays.fill(visited, false);


            while(!stack.isEmpty()) {
                int temp = stack.pop();
                if(!visited[temp]) {
                    DFSUtilAfterTranspose(temp);
                    System.out.println();
                }
            }

        }

        void transpose() {

            for(int i=0; i<v; i++) {
                int len = adj[i].size();
                for(int j=0; j<len; j++) {
                    int temp = adj[i].get(j);
                    adjT[temp].add(i);
                }
            }

        }
    }


    public void test() {

        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.findSCC();
    }
}
