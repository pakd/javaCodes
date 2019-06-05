import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {

    QueueCollection() {
        Queue<String> Q = new LinkedList<>();
        Q.add("dog");
        Q.add("cat");
        Q.add("monkey");

        System.out.println(Q);

        Q.remove();

        System.out.println(Q);

        System.out.println(Q.peek());

        // study offer, poll and peek of BlockingQueue

    }
}
