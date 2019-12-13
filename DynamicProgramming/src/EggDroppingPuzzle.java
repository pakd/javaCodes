import java.util.Arrays;

public class EggDroppingPuzzle {

    // n eggs , k floors
    public int minWays(int n, int k) {

        int[][] dp = new int[n+1][k+1];

        // base conditions

        for(int i=0; i<=n; i++) {
            Arrays.fill(dp[i], 0);
        }

        // 1 egg, k floors
        for(int i=1; i<=k; i++) {
            dp[1][i] = i;
        }

        // n eggs, 1 floor
        for(int i=1; i<=n; i++) {
            dp[i][1] = 1;
        }

        for(int i=2; i<=n; i++) {
            for(int j=2; j<=k; j++) {


                int min = Integer.MAX_VALUE;

                for(int x=1; x<=j; x++) {

                    // if egg breaks at xth floor, we are left with n-1 eggs and x -1 floors = dp[i-1][j-1]
                    // if egg doesnt break at xth floor, we are left with n eggs and k-x floors = dp[i][k-x]
                    int ways = 1 + Math.max(dp[i-1][x-1], dp[i][j-x]);
                    min = Math.min(ways, min);
                }
                dp[i][j] = min;
            }
        }


        for(int i=0; i<=n; i++) {
            for(int j=0; j<=k; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        return dp[n][k];


    }

    public void test() {

        int nEggs = 2;
        int kFloors = 36;
        System.out.println(minWays(nEggs, kFloors));
    }
}
