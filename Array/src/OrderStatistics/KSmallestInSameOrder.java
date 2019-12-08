package OrderStatistics;

public class KSmallestInSameOrder {

    public void ksmallest(int[] arr, int k) {
        int n = arr.length;

        for(int i = k; i<n; i++) {

            int pos = 0;
            int max = arr[pos];

            for(int j=1; j<k; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    pos = j;
                }
            }


            if(arr[i] < max) {
                int it = pos;
                for(;it<k-1;it++ ) {
                    arr[it] = arr[it+1];
                }
                arr[k-1] = arr[i];
            }
        }

    }


    public void test() {
        int[] arr = { 1, 5, 8, 9, 6, 7, 3, 4, 2, 0 };
        int k = 5;
        ksmallest(arr, k);

        for(int i=0; i<k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
