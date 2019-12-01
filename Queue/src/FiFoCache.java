import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/*
Belady’s anomaly –
Belady’s anomaly proves that it is possible to have more page faults when increasing the number of page frames
while using the First in First Out (FIFO) page replacement algorithm. For example, if we consider reference
string 3, 2, 1, 0, 3, 2, 4, 3, 2, 1, 0, 4 and 3 slots, we get 9 total page faults,
but if we increase slots to 4, we get 10 page faults.
*/

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
