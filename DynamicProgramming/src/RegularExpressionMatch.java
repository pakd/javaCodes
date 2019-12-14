public class RegularExpressionMatch {

    public boolean isMatch(String str, String ptrn) {

        int strLen = str.length();
        int ptrnLen = ptrn.length();

        boolean[][] dp = new boolean[strLen+1][ptrnLen+1];

        // base conditions

        // matching two empty strings
        dp[0][0] = true;

        // matching empty string with non empty string
        for(int i=1; i <=strLen; i++)
        {
            dp[i][0] = false;
        }

        // matching empty string with non empty string
        for(int i=1; i <=ptrnLen; i++)
        {
            dp[0][i] = false;
        }


        for(int i=1; i<=strLen; i++) {
            for(int j=1; j<=ptrnLen; j++) {


                if( (str.charAt(i-1) == ptrn.charAt(j-1)) || ptrn.charAt(j-1)=='.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(ptrn.charAt(j-1) == '*') {


                    // checking 0 occurences
                    dp[i][j] = dp[i][j-2];

                    // checking more than 0 occurences
                    if(ptrn.charAt(j-2) == str.charAt(j-1)  || ptrn.charAt(j-2) == '.') {
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }

                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[strLen][ptrnLen];

    }

    public void test() {

        String str = "xaabyc";
        String ptrn = "xa*b.c";

        System.out.println(isMatch(str, ptrn));
    }
}
