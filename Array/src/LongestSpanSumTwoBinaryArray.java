import java.util.HashMap;
import java.util.Map;

public class LongestSpanSumTwoBinaryArray {


    public int findLongestSpan(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int[] diff = new int[n];

        for(int i=0; i<n; i++) {
            diff[i] = arr1[i] - arr2[i];
        }

        Map<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;
        int curr_sum = 0;

        for(int i=0; i<n; i++) {

            curr_sum += diff[i];


            if(curr_sum == 0) {

                maxLength = Math.max(maxLength, i+1);
            }

            if(map.containsKey(curr_sum) == true) {

                int temp_length = i - map.get(curr_sum);
                maxLength = Math.max(maxLength, temp_length );
            } else {
                map.put(curr_sum, i);
            }


        }

        return maxLength;
    }


    public void test() {

        int[]  arr1 = {0, 1, 0, 1, 1, 1, 1};
        int[]  arr2 = {1, 1, 1, 1, 1, 0, 1};
        System.out.println(findLongestSpan(arr1,arr2));
    }

}
