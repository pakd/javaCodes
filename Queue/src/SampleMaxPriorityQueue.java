import java.util.Comparator;
import java.util.PriorityQueue;

public class SampleMaxPriorityQueue {



    public void test() {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        maxHeap.add(4);
        maxHeap.add(8);
        maxHeap.add(3);
        maxHeap.add(6);

        System.out.println(maxHeap.peek());




        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(4);
        minHeap.add(8);
        minHeap.add(3);
        minHeap.add(6);

        System.out.println(minHeap.peek());
    }



}
