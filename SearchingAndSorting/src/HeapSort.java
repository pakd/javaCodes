public class HeapSort {

    public int leftChild(int index) {
        return 2*index+1;
    }
    public int rightChild(int index) {
        return 2*index+2;
    }


    public void max_heapify(int[] arr, int index, int size) {



        int largest = index;

        int l = leftChild(index);
        int r = rightChild(index);
        if(l< size && arr[largest] < arr[l]) {
            largest = l;
        }
        if(r<size && arr[largest] < arr[r]) {
            largest = r;
        }

        if(largest != index) {
            swap(arr, largest, index);
            max_heapify(arr, largest, size);
        }

    }


    public void heapsort(int[] arr) {
        int n = arr.length;
        for(int i=(n/2 - 1); i>=0; i--) {
            max_heapify(arr, i, n);
        }
        // got max heap

        for(int i=n-1; i>=0 ; i--) {
            swap(arr, i, 0);
            max_heapify(arr, 0, i);
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
        heapsort(arr);
        printArr(arr);

    }
}
