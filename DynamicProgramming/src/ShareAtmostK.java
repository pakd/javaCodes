public class ShareAtmostK {


    void printDP(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    int profit(int[] price, int k) {

        int n = price.length;

        int[][] profit = new int[k+1][n];

        // on day 0 profit will be 0
        for(int i=0; i<=k; i++) {
            profit[i][0] = 0;
        }
        // with 0 transaction profit will be 0
        for(int i=0; i<n; i++) {
            profit[0][i] = 0;
        }

        for(int i=1; i<=k; i++) {
            for(int j=1; j<n; j++) {

                int maxProfit = Integer.MIN_VALUE;

                for(int m=0; m<j; m++) {

                    int currProfit = price[j] - price[m] + profit[i-1][m];
                    maxProfit = Math.max(maxProfit, currProfit);
                }

                profit[i][j] = Math.max(maxProfit, profit[i][j-1]);
            }
        }

        printDP(profit);

        return profit[k][n-1];

    }

    public void test() {

        int k = 2;
        int price[] = { 10, 22, 5, 75, 65, 80 };
        System.out.println(profit(price, 2));
    }
}
