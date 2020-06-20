import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIslandII {

    public int safeR = 0;
    public int safeC = 0;

    class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Node {
        Coordinate cordinate;
        int step;
        Node(Coordinate cordinate, int step) {
            this.cordinate = cordinate;
            this.step = step;
        }
    }

    TreasureIslandII() {
        char[][] island = new char[][]{
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}
        }; // ans = 3

//        char[][] island = new char[][] {
//                {'S', 'O', 'O', 'S', 'S'},
//                {'D', 'O', 'D', 'O', 'O'},
//                {'O', 'O', 'O', 'O', 'X'},
//                {'X', 'D', 'D', 'O', 'O'},
//                {'X', 'D', 'D', 'D', 'O'}
//        }; // ans = 2

        this.safeR = island.length;
        this.safeC = island[0].length;

        System.out.println(findMinPathMultiSource(island));
    }


    public boolean isSafe(int i, int j, char[][] island, boolean[][] visited) {
        if(i >= 0 && i < safeR && j >= 0 && j<safeC && !visited[i][j] && island[i][j] != 'D') {
            return true;
        }
        return false;
    }

    public int findMinPathMultiSource(char[][] island) {

        // all four directions
        int[][] dirs = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        boolean[][] visited = new boolean[safeR][safeC];

        for(int i=0; i<safeR; i++) {
            Arrays.fill(visited[i], false);
        }


        Queue<Node> q = new LinkedList<>();

        //starting nodes

        for(int i = 0; i < safeR; i++){
            for(int j = 0; j < safeC; j++){
                if(island[i][j] == 'S'){
                    q.add(new Node(new Coordinate(i, j), 0));

                    // mark starting node as D to block other paths
                    // as shortest path can not be there from this blocked path
                    island[i][j] = 'D';
                    visited[i][j] = true;
                }
            }
        }


        while(!q.isEmpty()) {

            Node temp = q.remove();
            int x = temp.cordinate.x;
            int y = temp.cordinate.y;

            if(island[x][y] == 'X') {
                return temp.step;
            }

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isSafe(newX, newY, island, visited)) {
                    q.add(new Node(new Coordinate(newX, newY), temp.step + 1));
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }

}
