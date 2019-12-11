public class MinimumEditDistance {


    int minEditDist(String in, String out) {

        int inLen = in.length();
        int outLen = out.length();

        int[][] dp = new int[inLen + 1][outLen + 1];


        for (int i = 0; i <= inLen; i++) {
            for (int j = 0; j <= outLen; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }

                else if(j == 0) {
                    dp[i][j] = i;
                }

                else if(in.charAt(i-1) == out.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }

                else {
                    dp[i][j] = 1 + Math.min(
                            dp[i-1][j-1], // replace
                            Math.min(
                                    dp[i-1][j], // remove
                                    dp[i][j-1] // add
                            )
                    );
                }
            }
        }
        return dp[inLen][outLen];
    }


    public void test() {

        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(minEditDist(str1, str2));
    }
}
