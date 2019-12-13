public class OptimalStrategyForAGame {

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public void printScore(int[] arr) {

        int n = arr.length;
        Pair[][] dp = new Pair[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        for(int i=0; i<n; i++) {
            dp[i][i].first = arr[i];
            dp[i][i].second = 0;
        }

        for(int blockSize = 2; blockSize<=n; blockSize++ ) {

            for(int i=0; i<=n-blockSize; i++) {
                int j = i + blockSize -1;

                if(arr[i] + dp[i+1][j].second > arr[j] + dp[i][j-1].second) {
                    dp[i][j].first = arr[i] + dp[i+1][j].second;
                    dp[i][j].second = dp[i+1][j].first;
                } else {
                    dp[i][j].first = arr[j] + dp[i][j-1].second;
                    dp[i][j].second = dp[i][j-1].first;
                }
            }
        }


        System.out.println(dp[0][n-1].first + " " + dp[0][n-1].second);
    }

    public void test() {

        int[] arr = {8, 15, 3, 7};
        printScore(arr);
    }
}
