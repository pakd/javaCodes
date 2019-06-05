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

    static void testTreeMap()
    {
        TreeMapCollection treeMapSample = new TreeMapCollection();
        treeMapSample.TreeMapSample();
    }

    static void testLinkedHashMap()
    {
        LinkedHashMapCollection linkedHashMapCollection = new LinkedHashMapCollection();
        linkedHashMapCollection.LinkedHashMapSample();
    }

    public static void main(String[] args) {

        // testArrayList(); // 1

        // testLinkedList(); // 2

        // testHashMap(); // 3

        // testLinkedHashMap(); // 4

        testTreeMap(); // 5

    }
}
