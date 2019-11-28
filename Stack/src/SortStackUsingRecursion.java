import java.util.Stack;

public class SortStackUsingRecursion {

    Stack<Integer> stack;

    private void sortInsert(int elem) {
        if( stack.isEmpty() || (stack.peek() < elem) ) {
            stack.push(elem);
            return;
        }

        int temp = stack.pop();
        sortInsert(elem);
        stack.push(temp);
    }

    public void sortStack() {
        if(stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();

        sortStack();

        sortInsert(temp);
    }

    public void test__sort_stack() {
        stack = new Stack<>();

        stack.push(-5);
        stack.push(10);
        stack.push(7);
        stack.push(4);
        System.out.println(stack);
        sortStack();
        System.out.println(stack);

    }
}
