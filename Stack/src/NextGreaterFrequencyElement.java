import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterFrequencyElement {

    public void findNGF(int[] arr, int[] next) {

        Map<Integer, Integer> map = new HashMap<>();

        int n = arr.length;

        for(int i=0; i<n; i++) {
            // int count = map.containsKey(arr[i])? map.get(arr[i]):0;
            // map.put(arr[i], count + 1);
            map.merge(arr[i], 1, Integer::sum);
        }

        Stack<Integer> stack = new Stack<>();


        stack.push(0);

        for(int i=1; i< n; i++) {
            while(stack.isEmpty() == false && map.get(arr[stack.peek()]) < map.get(arr[i])) {
                next[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }

        while(stack.isEmpty() == false) {
            next[stack.peek()] = -1;
            stack.pop();
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
        int[] arr = {1, 1, 2, 3, 4, 2, 1};
        int[] next = new int[arr.length];
        findNGF(arr, next);
        printArr(next);

    }
}
