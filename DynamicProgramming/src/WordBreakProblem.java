import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

    WordBreakProblem() {
        dictInit();
    }

    Set<String> dictionary;

    void dictInit() {
        String[] dictionaryWords = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};

        dictionary = new HashSet<>();

        for(String it : dictionaryWords) {
            dictionary.add(it);
        }

    }

    boolean isPresent(String word) {
        return dictionary.contains(word);
    }

    public boolean wordBreak(String str) {

        int len = str.length();

        if(len == 0) {
            return false;
        }

        boolean[][] dp = new boolean[len][len];
        for(int i=0; i<len; i++) {
            Arrays.fill(dp[i], false);
        }

        for(int blockSize = 1; blockSize<=len; blockSize++) {

            for(int i=0; i<=len-blockSize; i++) {

                int subStringEnd = i + blockSize -1;

                // starting index inclusive, ending index exclusive
                String subString = str.substring(i, subStringEnd+1);


                if(isPresent(subString)) {
                    dp[i][subStringEnd] = true;
                } else {
                    for(int k=i; k<subStringEnd; k++) {
                        if(dp[i][k] && dp[k+1][subStringEnd]) {
                            dp[i][subStringEnd] = true;
                            break;
                        }
                    }
                }


            }

        }
        return dp[0][len-1];


    }



    public void test() {


        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("ilikeicecreamiiii"));
        System.out.println(wordBreak("il0keicecreamiiii"));
        System.out.println(wordBreak("zebra"));
        System.out.println(wordBreak("samsungisamsung"));
    }
}
