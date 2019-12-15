public class PalindromicPartitioning {

    boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;

        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }

    int findMinimumNoOfCuts(String str) {

        int len = str.length();

        int[][] dp = new int[len][len];


        // base conditions
        for(int i=0; i<len; i++)
        {
            dp[i][i] = 0;
        }

        // substrings of length 2
        for(int i=0; i<len-1; i++) {
            dp[i][i+1] = (str.charAt(i) == str.charAt(i+1))? 0 :1 ;
        }

        for(int windowsSize = 3; windowsSize<=len; windowsSize++) {
            for(int i=0; i<=len-windowsSize; i++) {

                int j = i + windowsSize - 1;

                if(isPalindrome(str.substring(i, j+1))) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=i; k<j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1+ dp[i][k] + dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][len-1];
    }

    public void test() {

        //String str = "edadadgog"; // 2
        //String str = "babababz"; // 1
        String str = "abcd"; // 3
        System.out.println(findMinimumNoOfCuts(str));
    }
}
