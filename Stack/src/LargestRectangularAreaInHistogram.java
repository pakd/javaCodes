import java.util.Stack;

public class LargestRectangularAreaInHistogram {

    public int getMaxArea(int[] hist) {
        int n = hist.length;
        Stack<Integer> stack = new Stack<>();

        int curr_area = 0;
        int max_area = 0;

        int i=0;

        while(i<n) {
            if(stack.isEmpty() == true || hist[stack.peek()] <= hist[i] ) {
                stack.push(i++);
            } else {
                int top = stack.pop();

                curr_area = hist[top] * ((stack.isEmpty() == true)? i: (i -stack.peek()-1));
                max_area = Math.max(curr_area, max_area);
            }
        }

        while(!stack.isEmpty() == false) {
            int top = stack.peek();
            curr_area = hist[top] * ((stack.isEmpty())? i: i - stack.peek() - 1);
            max_area = Math.max(curr_area, max_area);
        }

        return max_area;
    }

    public void test() {
        int[] hist = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(getMaxArea(hist));
    }
}
