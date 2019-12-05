public class GenerateAllPermutations {

    public void generate(int[] arr) {

        int n = arr.length;
        double total = Math.pow(2, n);

        for(int i=1; i<total; i++) {


            for(int j=0; j<n; j++) {

                if( (i & (1 << j)) >0 ) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();


        }



    }

    public void generate_subarrays(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {

                for(int k=i; k<=j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public void test() {
        int[] arr = {1, 2, 3, 4};
        generate(arr);
        System.out.println("all subarrays");
        generate_subarrays(arr);
    }
}
