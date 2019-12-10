package Searching;

public class MedianOfTwoSortedArray {

    public double median(int[] arr1, int[] arr2) {

        if(arr1.length > arr2.length) {
            return median(arr2, arr1);
        }

        int n = arr1.length;
        int m = arr2.length;

        int start = 0;
        int end = n-1;

        while(start <= end) {

            int midX = (start+end)/2;
            int j = (n + m + 1)/2 - midX;

            int maxLeftX = (midX==0)? Integer.MAX_VALUE:arr1[midX-1];
            int minRightX = (midX == n)?Integer.MIN_VALUE:arr1[midX];
            int maxLeftY = (j==0)? Integer.MAX_VALUE:arr2[j-1];
            int minRightY = (j == m)?Integer.MIN_VALUE:arr2[j];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // even
                if( (n+m)%2==0) {
                    return (double)(Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if(maxLeftX > minRightY) {
                end = midX-1;
            } else {
                start = midX+1;
            }
        }

        return -1;


    }

    public void test() {

        int arr1[] = {1,3,8,9,15};
        int arr2[] = {7,11,18,19,21,25};
        System.out.println(median(arr1, arr2));

    }
}
