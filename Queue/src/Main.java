public class Main {

    public static void main(String[] args) {


//        // test reversing a queue using recursion
//        ReverseAQueueUsingRecursion reverseAQueueUsingRecursion = new ReverseAQueueUsingRecursion();
//        reverseAQueueUsingRecursion.test();
//
//        testLRUCache();

        testFiFoCache();

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
}
