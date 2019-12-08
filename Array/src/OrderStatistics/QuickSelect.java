package OrderStatistics;

public class QuickSelect {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int partition(int[] arr, int l, int r) {
        int key = arr[r];

        int index = l-1;

        for(int i=l; i<r; i++) {
            if(arr[i] <= key) {
                index++;
                swap(arr, index, i);
            }
        }
        swap(arr, index+1, r);
        return index+1;
    }

    int quickSelect(int[] arr, int L, int R, int k) {


        if(k >0 && k <= R - L +1) {

            int pos = partition(arr, L, R);

            if(pos-L == k-1) {
                return arr[pos];
            } else if( pos-L > k-1) {
                return quickSelect(arr, L, pos-1, k);
            } else {
                return quickSelect(arr, pos+1, R, (k-1) - (pos-L) );
            }
        }

        return Integer.MIN_VALUE;

    }

    public void test() {

        int[] arr = {12, 3, 5, 7, 4, 19, 26};

        System.out.println(quickSelect(arr, 0, arr.length-1, 3));
    }
}
