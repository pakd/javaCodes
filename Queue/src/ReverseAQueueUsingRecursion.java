import java.util.LinkedList;
import java.util.Queue;

public class ReverseAQueueUsingRecursion {

    Queue<Integer> Q;

    public void reverse() {
        if(Q.isEmpty() == true) {
            return;
        }

        int temp = Q.remove();

        reverse();

        Q.add(temp);
    }

    public void test() {
        Q = new LinkedList<>();
        Q.add(1);
        Q.add(2);
        Q.add(3);
        Q.add(4);

        System.out.println(Q);

        reverse();

        System.out.println(Q);
    }
}
