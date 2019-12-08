package OrderStatistics;

public class MaximumSumNoAdjacentAllowed {

    public int sum(int[] arr) {

        int n = arr.length;
        int incl = arr[0]; // including first element
        int excl = 0; // excluding first element


        for(int i=1; i<n; i++) {

            int excl_temp = Math.max(incl, excl);

            incl = excl + arr[i];
            excl = excl_temp;
        }
        return Math.max(incl, excl);
    }


    public void test() {
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println(sum(arr));

    }
}
