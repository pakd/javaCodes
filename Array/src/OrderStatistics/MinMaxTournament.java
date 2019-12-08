package OrderStatistics;

public class MinMaxTournament {

    class Node {
        int minimum;
        int maximum;

        Node(int minimum, int maximum) {
            this.minimum = minimum;
            this.maximum = maximum;
        }

    }


    public Node min_max(int[] arr, int low, int high) {

        if(low == high) {
            return new Node(arr[low], arr[high]);
        }

        if(low+1 == high) {

            int max = Math.max(arr[low], arr[high]);
            int min = Math.min(arr[low], arr[high]);

            return new Node(min, max);
        }

        int mid = (low+high)/2;

        Node left = min_max(arr, low, mid);
        Node right = min_max(arr, mid+1, high);

        int min = Math.min(left.minimum, right.minimum);
        int max = Math.max(left.maximum, right.maximum);

        return new Node(min, max);
    }

    public void test() {
        int[] arr = {1000, 11, 445, 1, 330, 3000, 451, 265};

        Node ans = min_max(arr, 0, arr.length-1);
        System.out.println("Minimum in array : " + ans.minimum);
        System.out.println("Maximum in array : " + ans.maximum);

    }

}
