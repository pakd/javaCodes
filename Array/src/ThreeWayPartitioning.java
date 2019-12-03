public class ThreeWayPartitioning {

    public void partition(int[] arr, int m1, int m2) {


        int n = arr.length;

        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid<=high) {

            if(arr[mid] < m1) {
                swap(arr, low, mid);
                low++; mid++;
            } else if(m1 <= arr[mid] && arr[mid] <= m2) {
                mid++;
            } else if(arr[mid] > m2) {
                swap(arr, mid, high);
                high--;
                // no need to increment mid as we have to check unprocessed value
            }
        }


    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArr(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void test() {
        int[] arr = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32, 15, 17, 18};
        partition(arr, 14, 20);
        printArr(arr);

    }


}
