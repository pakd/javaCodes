package Searching;

public class CountFrequencyUsingIndex {

    private void count(int[] arr) {

        int n = arr.length;

        int i=0;

        while(i<n) {

            // if element is already processed
            if(arr[i] < 0) {
                i++;
                continue;
            }

            if(arr[i] == i  && i!=0) {
                arr[i] = -1;
                i++;
            } else {
                if(arr[arr[i]] > 0) {

                    int temp = arr[arr[i]];
                    arr[arr[i]] = -1;
                    arr[i] = temp;
                } else {
                    arr[arr[i]] -= 1;
                    arr[i] = 0;
                    i++;
                }
            }
        }

    }

    public void test() {

        int[] arr = {1,2,3,3,4,5,6,5};
        count(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.println(i + " " + -(1*arr[i]));
        }

    }
}
