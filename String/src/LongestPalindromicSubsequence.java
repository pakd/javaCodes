public class LongestPalindromicSubsequence {

    public int findLongestPalindromicSubsequence(String str) {

        int len = str.length();

        int[][] dp = new int[len][len];


        // base conditions
        for(int i=0; i<len; i++)
        {
            dp[i][i] = 1;
        }

        // substrings of length 2
        for(int i=0; i<len-1; i++) {
            dp[i][i+1] = (str.charAt(i) == str.charAt(i+1))? 2 :1 ;
        }

        for(int windowsSize = 3; windowsSize<=len; windowsSize++) {
            for(int i=0; i<=len-windowsSize; i++) {

                int j = i + windowsSize - 1;

                dp[i][j] = (str.charAt(i) == str.charAt(j))?2 + dp[i+1][j-1]:Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }

        return dp[0][len-1];
    }

    public void test() {

        String str ="GEEKSFORGEEKS"; // 5 = EEKEE

        System.out.println(findLongestPalindromicSubsequence(str));
    }
}
