import java.util.Stack;

public class StackCollection {

    StackCollection() {
        Stack<String> stack = new Stack<String>();

        stack.push("first");
        stack.add("second");
        stack.push("third");


        System.out.println(stack);

        stack.pop();

        System.out.println(stack);

        while(!stack.isEmpty())
        {
            System.out.println(stack.peek());
            stack.pop();
        }

        System.out.println(stack);


    }
}
