public class BSInRotatedNSortedArray {

    public int search(int[] arr, int low, int high, int key) {

        if(low > high) {
            return -1;
        }

        int mid = (low + high)/2;

        if(arr[mid] == key) {
            return mid;
        } else if(arr[low] <= arr[mid]) { // left part is sorted
            // element present in left part
            if(arr[low] <= key && key <= arr[mid]) {
                return search(arr, low, mid-1, key);
            } else { // element present in right part
                return search(arr, mid+1, high ,key);
            }

        } else { // right part is sorted
            // element present in right part
            if(arr[mid] <= key && key <= arr[high]) {
                return search(arr, mid+1, high ,key);
            } else { // element present in left part
                return search(arr, low, mid-1, key);
            }

        }
    }


    public void test() {
        int[] arr = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(search(arr, 0, arr.length -1, 9));
        System.out.println(search(arr, 0, arr.length -1, 2));
        System.out.println(search(arr, 0, arr.length -1, 10));

    }
}
