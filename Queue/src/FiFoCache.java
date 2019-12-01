import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FiFoCache {

    public int capacity;
    public Set<Integer> set;
    public Queue<Integer> queue;
    public int count = 0;
    public int page_fault = 0;


    FiFoCache(int size) {
        this.capacity = size;
        set = new HashSet<>();
        queue = new LinkedList<>();
    }

    public void refer(int key) {

        if(set.contains(key) != true) {

            if(count < capacity) {
                set.add(key);
                queue.add(key);
                page_fault++;
                System.out.println("page fault");
                count++;
                System.out.println(queue);
            } else {
                int item = queue.peek();
                queue.remove();
                set.remove(item);

                set.add(key);
                queue.add(key);

                page_fault++;
                System.out.println("page fault");
                System.out.println(queue);
            }
        } else {
            System.out.println(queue);

        }
    }


}
