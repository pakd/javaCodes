public class MoveZeroesToEnd {

    public void move(int[] arr) {

        int n = arr.length;

        int prev = -1;

        for(int i=0; i<n; i++) {
            if(arr[i] == 1) {
                prev++;
                swap(arr, i, prev);
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
        int[] arr = { 1 , 0, 1, 0, 1, 0, 0, 1, 1, 1};
        move(arr);
        printArr(arr);

    }
}
