public class RabinKarpSearch {

    int prime = 101;

    boolean checkEqual(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
        if( (end1-start1) != (end2-start2) ) {
            return false;
        }
        int i = start1;
        int j = start2;
        while(i <= end1 && j <= end2) {
            if(str1[i] != str2[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    // only once called in starting
    long calculateHash(char[] str, int end) {

        long hash = 0;
        for(int i=0; i<=end; i++) {
            hash += str[i]*Math.pow(prime, i);
        }
        return hash;
    }

    long recalculateHash(char[] str, int oldStart, int oldEnd, long oldHash, int patternLen) {

        long newHash = oldHash;
        newHash -= str[oldStart];
        newHash/=prime;
        newHash = newHash + (long)(str[oldEnd+1] * Math.pow(prime, patternLen-1));
        return newHash;

    }

    public void search(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;

        long patternHash = calculateHash(pattern, m-1);
        long textHash = calculateHash(text, m-1);

        for(int i=1; i<=n-m+1; i++) {
            if( (patternHash == textHash) && checkEqual(text, i-1, i+m-2, pattern, 0, m-1)) {
                System.out.println(i-1);
            }
            if(i<n-m+1) {
                textHash = recalculateHash(text, i-1, i+m-2, textHash, m);
            }

        }

    }

    public void test() {
        String text = "GEEKSFORGEEKS";
        String pattern = "GEEKS";
        search(text.toCharArray(), pattern.toCharArray());
    }
}
