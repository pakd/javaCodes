import java.util.Arrays;

public class RatInAMazeProblem {

    // assuming 4x4 Matrix
    int N = 4;

    void printSolution(int[][] sol)
    {
        for(int i=0; i<sol.length; i++) {
            for(int j=0; j<sol[i].length; j++) {
                System.out.print(sol[i][j]);
            }
            System.out.println();
        }

    }



    boolean isSafe(int[][] maze, int x, int y)
    {
        // if (x,y outside maze) return false
        if(x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1)
        {
            return true;
        }
        return false;
    }

    public boolean solveMazeUtil(int[][] maze, int[][] sol, int x, int y) {

        // solution found
        if(x == N-1 && y == N-1) {
            sol[x][y] = 1;
            return true;
        }

        if(isSafe(maze, x, y)) {


            sol[x][y] = 1;

            if(solveMazeUtil(maze, sol, x+1, y)) {
                return true;
            }

            if(solveMazeUtil(maze, sol, x, y+1)) {
                return  true;
            }

            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public void solveMaze(int[][] maze) {

        int[][] sol = new int[N][N];
        for(int i=0; i<sol.length; i++) {
            Arrays.fill(sol[i], 0);
        }

        if(!solveMazeUtil(maze, sol, 0, 0)) {
            System.out.println("no solution");
        } else {

            printSolution(sol);
        }
    }


    public void test() {




        int[][] maze  =  {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        solveMaze(maze);
    }
}
