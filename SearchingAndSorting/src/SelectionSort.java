public class SelectionSort {

    public void sort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++) {
            int position = i;
            for(int j=i+1; j<n; j++) {
                if(arr[position] > arr[j]) {
                    position = j;
                }
            }
            if(position != i) {
                swap(arr, i, position);
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
