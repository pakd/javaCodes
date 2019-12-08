package OrderStatistics;

public class KMaximumSumSubArrayNonOverlapping {

    class Node {
        int sum;
        int first;
        int last;

        public Node(int sum, int first, int last) {
            this.sum = sum;
            this.first = first;
            this.last = last;
        }
    }

    public Node kadanes(int[] arr) {

        int n = arr.length;

        int curr_max = 0;
        int max_so_far = Integer.MIN_VALUE;

        int leftIndex = 0;
        int rightIndex = 0;
        int s = 0;

        for(int i=0; i<n; i++) {
            curr_max += arr[i];

            if(max_so_far < curr_max) {

                max_so_far = curr_max;
                leftIndex = s;
                rightIndex = i;

            }

            if(curr_max < 0) {
                curr_max = 0;
                s = i+1;
            }
        }

        return new Node(max_so_far, leftIndex, rightIndex);
    }


    public void find(int[] arr, int k) {

        for(int i=0; i<k; i++) {
            Node temp = kadanes(arr);

            System.out.println(temp.sum + " {" + temp.first + " ->" + temp.last + "}");
            for(int j= temp.first; j<= temp.last; j++ ) {
                arr[j] = Integer.MIN_VALUE;
            }
        }

    }

    public void test() {

        int[] arr = {4, 1, 1, -1, -3, -5, 6, 2, -6, -2};

        int k = 3;

        find(arr, k);
    }
}
