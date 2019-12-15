public class KnuthMorrisPratt {

    void knuthMorrisPrattSearch(String text, String pattern) {

        int patLen = pattern.length();
        int textLen = text.length();

        int[] lps = computeLPS(pattern);

        for(int i=0; i<patLen; i++) {
            System.out.print(lps[i] + " ");
        }
        System.out.println();

        int i = 0; // for text
        int j = 0; // for pattern

        while(i < textLen) {

            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if(j == patLen) {
                System.out.println("Pattern found at : " + (i - patLen));
                j = lps[j-1];
            } else if(i < textLen && text.charAt(i) != pattern.charAt(j)){
                if(j!=0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
    }

    int[] computeLPS(String pattern) {

        int len = pattern.length();
        int[] lps = new int[len];

        int i = 1;
        int j = 0;

        lps[0] = 0;
        while(i < len) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = lps[j] + 1;
                i++;
                j++;
            } else {
                if(j!=0) {

                    j = lps[j-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }

        }
        return lps;
    }

    public void test() {
        String text = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";

        knuthMorrisPrattSearch(text, pat);
    }
}
