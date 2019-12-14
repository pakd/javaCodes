import java.util.LinkedList;
import java.util.List;

public class MatrixChainMultiplication {

    List<Matrix> list;

    class Matrix {
        int row;
        int col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int minCost() {

        int n = list.size();
        int[][] dp = new int[n][n];

        // cost of multiplying matrix with itself
        for(int i=0; i<n; i++) {
            dp[i][i] = 0;
        }

        for(int blockSize = 2; blockSize<=n; blockSize++) {
            for(int i=0; i<=n-blockSize; i++) {
                int j = i + blockSize -1;

                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i; k<j; k++) {
                    int temp = dp[i][k] + dp[k+1][j] + (list.get(i).row * list.get(j).col * list.get(k).col);
                    dp[i][j] = Math.min(temp, dp[i][j]);
                }
            }
        }

        return dp[0][n-1];
    }

    public void test() {

        list = new LinkedList<>();
        list.add(new Matrix(1,2));
        list.add(new Matrix(2,3));
        list.add(new Matrix(3,4)); // ans = 18

//        list.add(new Matrix(40,20));
//        list.add(new Matrix(20,30));
//        list.add(new Matrix(30,10));
//        list.add(new Matrix(10,30)); // ans = 26000

        System.out.println(minCost());

    }
}
