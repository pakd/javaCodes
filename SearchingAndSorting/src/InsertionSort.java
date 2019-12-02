public class InsertionSort {

    public void sort(int[] arr) {
        int n = arr.length;

        for(int i=1; i<n; i++) {
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]) {
                swap(arr, j, j-1);
                j--;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void test() {
        int[] arr = {10,5,2,4,-1};
        sort(arr);
        printArr(arr);

    }


}
