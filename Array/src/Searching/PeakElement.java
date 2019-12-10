package Searching;

public class PeakElement {

    public int findPeakElement(int[] arr, int start, int end) {

        int mid = (start + end)/2;
        int n = arr.length;
        if ( (mid==0 || arr[mid]>=arr[mid-1]) && (mid==n-1 || arr[mid]>=arr[mid+1])) {
            return mid;
        } else if(mid > 0 && arr[mid-1] > arr[mid]) {
            return findPeakElement(arr, start, mid-1);

        } else {
            return findPeakElement(arr, mid+1, end);
        }
    }


    public void test() {
        int arr[] = {10, 20, 15, 2, 23, 90, 67};
        System.out.println(arr[findPeakElement(arr, 0, arr.length-1)]);
    }
}
