package Searching;

public class CeilingInSortedArray {

    public int findCeiling(int[] arr, int start, int end, int key) {
        if(arr[start] > key ) {
            return start;
        }
        if(arr[end] < key) {
            return end;
        }

        int mid = (start + end)/2;

        if(arr[mid] == key) {
            return mid;
        } else if(arr[mid] < key) {

            if(mid < arr.length-1 && arr[mid+1] >= key ) {
                return mid+1;
            }
            return findCeiling(arr, mid+1, end, key);
        } else {
            if(mid > 0 && arr[mid-1] < key) {
                return mid;
            }
            return findCeiling(arr, start, mid-1, key);
        }
    }

    public void test() {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        System.out.println(arr[findCeiling(arr, 0, arr.length-1, 11)]);

    }
}
