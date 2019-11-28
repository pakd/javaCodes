import java.util.Stack;

public class ReverseStackUsingRecursion {

    Stack<Integer> stack;

    public void reverseStack() {
        if(stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();
        reverseStack();
        insertAtBottom(temp);
    }

    private void insertAtBottom(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(x);
        stack.push(temp);
    }

    public void test_stack_reversal() {
        stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        reverseStack();
        System.out.println(stack);

    }
}
