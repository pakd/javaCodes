public class MaximumProductSubArray {

    public int maxProduct(int[] arr) {

        int n = arr.length;
        int min_val = 1;
        int max_val = 1;
        int max_so_far = 1;

        for(int i=0; i<n; i++) {


            if(arr[i] > 0) {
                max_val = max_val * arr[i];
                min_val = min_val * arr[i];
            } else if(arr[i] == 0) {
                min_val = 1;
                max_val = 1;
            } else {
                int temp = min_val;
                min_val = max_val * arr[i];
                max_val = temp * arr[i];
            }

            if(max_so_far < max_val) {
                max_so_far = max_val;
            }
        }

        return max_so_far;
    }

    public void test() {
        // int[] arr = {1, -2, -3, 0, 7, -8, -2}; // 112
        int[]  arr = {6, -3, -10, 0, 2}; // 180

        System.out.println(maxProduct(arr));
    }
}
