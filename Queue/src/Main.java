public class Main {

    public static void main(String[] args) {


//        // test reversing a queue using recursion
//        ReverseAQueueUsingRecursion reverseAQueueUsingRecursion = new ReverseAQueueUsingRecursion();
//        reverseAQueueUsingRecursion.test();
//
//        testLRUCache();
//
//        testFiFoCache();
//
//        testNQueues();
//
//        // test smallest multiple of 9 and 0
//        SmallestMultipleUsing9_0 smallestMultipleUsing9_0 = new SmallestMultipleUsing9_0();
//        smallestMultipleUsing9_0.test();
//
//        // test rotten oranges problem
//        RottenOranges rottenOranges = new RottenOranges();
//        rottenOranges.test();
//
//        // test circular petrol pump problem
//        CircularPetrolPumpProblem circularPetrolPumpProblem = new CircularPetrolPumpProblem();
//        circularPetrolPumpProblem.test();

        SampleMaxPriorityQueue sampleMaxPriorityQueue = new SampleMaxPriorityQueue();
        sampleMaxPriorityQueue.test();

    }

    public static void testLRUCache() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(1, 10);
        lruCache.set(2, 20);

        System.out.println(lruCache.get(1));

        lruCache.set(3, 30);
        System.out.println(lruCache.get(2));

        lruCache.set(4, 40);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    public static void testFiFoCache() {
        FiFoCache fifoCache = new FiFoCache(4);
        int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        for (int i : pages) {
            fifoCache.refer(i);
        }
        System.out.println("Page Faults No: " + fifoCache.page_fault);
    }

    public static void testNQueues() {
        int n = 10;
        int k = 3;
        NQueues ks = new NQueues(10, 3);


        // Let us put some items in queue number 2
        ks.enqueue(2, 15);
        ks.enqueue(2, 45);

        // Let us put some items in queue number 1
        ks.enqueue(1, 17);
        ks.enqueue(1, 49);
        ks.enqueue(1, 39);

        // Let us put some items in queue number 0
        ks.enqueue(0, 11);
        ks.enqueue(0, 9);
        ks.enqueue(0, 7);

        System.out.println(ks.deque(2));
        System.out.println(ks.deque(1));
        System.out.println(ks.deque(0));

    }
}
