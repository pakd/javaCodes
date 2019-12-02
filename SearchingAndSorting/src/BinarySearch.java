public class BinarySearch {

    public int search(int[] arr, int l, int r, int key) {

        if(l > r) {
            return -1;
        }
        int mid = (l + r)/2;
        if(key == arr[mid]) {
            return mid;
        } else if(key < arr[mid]) {
            return search(arr, l, mid-1, key);
        } else {
            return search(arr, mid+1, r, key);
        }
    }

    public void test() {
        int[] arr = {4, 7, 18, 24, 34, 45, 56, 78, 98, 101};
        System.out.println(search(arr, 0, arr.length-1, 24));
        System.out.println(search(arr, 0, arr.length-1, 78));
        System.out.println(search(arr, 0, arr.length-1, 20));
    }
}
