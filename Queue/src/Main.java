public class Main {

    public static void main(String[] args) {


//        // test reversing a queue using recursion
//        ReverseAQueueUsingRecursion reverseAQueueUsingRecursion = new ReverseAQueueUsingRecursion();
//        reverseAQueueUsingRecursion.test();

        testLRUCache();

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
}
