public class Main {

    public static void main(String[] args) {

        LinkedListLibrary linkedListLibrary = new LinkedListLibrary();

        // test display linked list
        linkedListLibrary.test_display();

        // test count no. of nodes
        linkedListLibrary.test_count_nodes();

        // test insert node
        linkedListLibrary.test_insert_node();

        // test add two list
        AddTwoLinkedList addTwoLinkedList = new AddTwoLinkedList();
        addTwoLinkedList.test_add_lists();

        // test find middle element
        FindMiddleNode findMiddleNode = new FindMiddleNode();
        findMiddleNode.test_find_middle_node();

        // test find square root node
        FindSquareRootNode findSquareRootNode = new FindSquareRootNode();
        findSquareRootNode.test_find_square_root_node();
    }


}