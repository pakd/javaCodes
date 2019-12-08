package RangeQuery;

public class PrefixSumQuery {

    public int sumQuery(int[] arr, int l, int r) {

        int n = arr.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];

        for(int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        if(l == 0) {
            return prefixSum[r];
        }

        return prefixSum[r] - prefixSum[l-1];
    }

    public void test() {

        int arr[] = {4,5,8,9,6,3,2,1};
        System.out.println(sumQuery(arr, 0 , 3  ));
    }
}
