import java.util.Arrays;

public class LongestIncreasingPathInMatrix {

    int N = 3;

    public int findLongestFromACell(int[][] mat, int[][] dp, int i, int j) {

        if(i<0 || i>=N || j<0 || j>=N) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }


        // left cell
        if( j>0 && (mat[i][j] + 1) == mat[i][j-1] )
        {
            return dp[i][j] = 1 + findLongestFromACell(mat, dp, i, j-1);
        }

        // right cell
        if( j<N-1 && (mat[i][j] + 1) == mat[i][j+1] )
        {
            return dp[i][j] = 1 + findLongestFromACell(mat, dp, i, j+1);
        }

        // top cell
        if( i>0 && (mat[i][j] + 1) == mat[i-1][j] )
        {
            return dp[i][j] = 1 + findLongestFromACell(mat, dp, i-1, j);
        }


        // bottom cell
        if( i<N-1 && (mat[i][j] + 1) == mat[i+1][j] )
        {
            return dp[i][j] = 1 + findLongestFromACell(mat, dp, i+1, j);
        }

        // if no neighbour cell return 1;
        return dp[i][j] = 1;
    }


    public int findLongestOverAll(int[][] mat) {

        // assuming square matrix
        int n = mat.length;

        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(dp[i][j] == -1) {
                    dp[i][j] = findLongestFromACell(mat, dp, i, j);
                    result = Math.max(dp[i][j] , result);
                }
            }
        }
        return result;

    }

    public void test() {
        int[][] mat = {
                { 1, 2, 9 },
                { 5, 3, 8 },
                { 4, 6, 7 }
        };

        System.out.println(findLongestOverAll(mat));
    }
}
