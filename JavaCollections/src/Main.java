public class Main {

    static void testHashMap() {

        HashMapCollection hashMapSample = new HashMapCollection();
        hashMapSample.HashMapSample();
    }

    static void testArrayList() {
        ArrayListCollection arrayListSample = new ArrayListCollection();
        arrayListSample.ArrayListSample();
    }

    static  void testLinkedList() {
        LinkedListCollection linkedListSample = new LinkedListCollection();
        linkedListSample.LinkedListSample();
    }
    public static void main(String[] args) {

        // uncomment ot run array list sample code
        // testArrayList();

        testLinkedList();

        // uncomment to run hash map sample code
        // testHashMap();

    }
}
