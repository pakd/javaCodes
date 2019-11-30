import java.util.Stack;

// please note solution is not correct
public class NumberOfNGEsOnRight {

    public void findNo(int[] arr, int[] next) {

        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1; i< n; i++) {
            while(stack.isEmpty() == false && arr[stack.peek()] < arr[i]) {
                next[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }

        while(stack.isEmpty() == false) {
            next[stack.peek()] = -1;
            stack.pop();
        }

    }

    public void countNGEs(int[] arr, int[] next, int[] dp) {
        int n = arr.length;
        dp[n-1] = 0;
        for(int i = n-2; i>=0; i--) {
            if(next[i] == -1) {
                dp[i] = 0;
            } else {
                dp[i] = 1 + dp[next[i]];
            }
        }
    }

    public void printArr(int[] arr) {
        int n = arr.length;
        for(int i=0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void test() {
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int size = arr.length;

        int[] next = new int[size];

        //printArr(arr);

        findNo(arr, next);
        int[] dp = new int[size];

        countNGEs(arr, next, dp);
        printArr(next);
        printArr(dp);
    }
}
