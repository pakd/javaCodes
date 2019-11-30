import java.util.Stack;

public class DeleteMiddleElementRecursion {

    Stack<Integer> stack;

    public void deleteMiddle(int sizeOfStack, int n) {
        if(stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        deleteMiddle(sizeOfStack, n-1);
        if(((sizeOfStack/2) + 1) != n) {
            stack.push(temp);
        }
    }

    public void test() {
        stack = new Stack<>();
        int i =1;
        for(;i<8;i++) {
            stack.push(i);
        }

        System.out.println(stack);
        deleteMiddle(stack.size(), stack.size());
        System.out.println(stack);
    }
}
