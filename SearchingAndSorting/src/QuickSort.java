public class QuickSort {

    public void quicksort(int[] arr, int l, int r) {
        if(l>=r) {
            return;
        }
        int pivot = partition(arr, l, r);
        quicksort(arr, l, pivot-1);
        quicksort(arr, pivot+1, r);

    }

    public int partition(int[] arr, int l, int r) {
        int key = arr[r];

        int i = l-1;

        for(int j=l; j<r; j++) {
            if(arr[j] <= key) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
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
        quicksort(arr, 0, arr.length-1);
        printArr(arr);

    }


}
