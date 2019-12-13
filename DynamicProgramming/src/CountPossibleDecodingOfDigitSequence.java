public class CountPossibleDecodingOfDigitSequence {


    public int countDecodings(String input) {

        int n = input.length();

        int[] countArr = new int[n+1];

        countArr[0] = 1;
        countArr[1] = 1;

        for(int i=2; i<=n; i++) {

            int total_ways = 0;
            if(input.charAt(i-1) > '0') {
                total_ways += countArr[i-1];
            }
            if(input.charAt(i-2)=='1' || (input.charAt(i-1)<='6' && input.charAt(i-2)=='2')) {
                total_ways += countArr[i-2];
            }

            countArr[i] = total_ways;
        }
        return countArr[n];
    }

    public void test() {
        String digits = "1234";
        System.out.println(countDecodings(digits));
    }
}
