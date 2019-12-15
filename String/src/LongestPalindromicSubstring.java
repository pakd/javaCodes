public class LongestPalindromicSubstring {

    public String buildString(String str, int i, int j) {
        return str.substring(i, j+1);
    }

    public void printLongestPalindromicSubstring(String str) {


        int len = str.length();

        boolean[][] dp = new boolean[len][len];

        int maxLength = 1;
        String ans = "";

        // base conditions
        for(int i=0; i<len; i++)
        {
            dp[i][i] = true; // substring with one character is always palindrome
        }

        // substrings of length 2
        for(int i=0; i<len-1; i++) {
            dp[i][i+1] = (str.charAt(i) == str.charAt(i+1))? true: false;
            if(dp[i][i+1]) {
                maxLength = 2;
                ans = buildString(str, i, i+1);
            }
        }

        for(int windowsSize = 3; windowsSize<=len; windowsSize++) {
            for(int i=0; i<=len-windowsSize; i++) {

                int j = i + windowsSize - 1;

                dp[i][j] = (str.charAt(i) == str.charAt(j))?dp[i+1][j-1]:false;
                if(dp[i][j]) {
                    maxLength = windowsSize;
                    ans = buildString(str, i, j);
                }
            }
        }

        System.out.println(ans);
    }


    public void test() {
        String str = "dbananabk"; // "banana"; //
        printLongestPalindromicSubstring(str);
    }
}
