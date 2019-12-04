public class MinimumOperationToMakePalindrome {

    public int findMinOps(int[] arr, int start, int end) {

        if(start >= end) {
            return 0;
        } else if(arr[start] == arr[end]) {
            return findMinOps(arr, start+1, end-1);
        } else if(arr[start] < arr[end]) {
            // merge array starting
            start++;
            arr[start] = arr[start] + arr[start-1];
            return 1 + findMinOps(arr, start, end);
        } else {
            end--;
            arr[end] = arr[end] + arr[end+1];
            return 1 + findMinOps(arr, start, end);
        }
    }

    public void test() {
        int[] arr =   {1, 4, 5, 1}; //   {15, 4, 15}; //   {11, 14, 15, 99};   // {1, 4, 5, 9, 1};
        System.out.println(findMinOps(arr, 0 , arr.length-1));
    }
}
