public class AddTwoLinkedList {

    public Node AddLists(Node head1, Node head2) {

        LinkedListLibrary linkedListLibrary = new LinkedListLibrary();

        int sum = 0;
        int carry = 0;
        int term = 0;

        Node head3 = null;

        while(head1 != null || head2 != null) {
            sum = ((head1 == null)?0:head1.data) + ((head2 == null)?0:head2.data) + carry;
            carry = sum/10;
            term = sum%10;
            head3 = linkedListLibrary.InsertNode(head3, term);

            if(head1 != null) {
                head1 = head1.next;
            }
            if(head2 != null) {
                head2 = head2.next;
            }
        }

        if(carry > 0) {
            head3 = linkedListLibrary.InsertNode(head3, carry);
        }
        return head3;
    }

    public void test_add_lists() {
        LinkedListLibrary linkedListLibrary = new LinkedListLibrary();

        Node head1 = null;

        head1 = linkedListLibrary.InsertNode(head1, 7);
        head1 = linkedListLibrary.InsertNode(head1, 5);
        head1 = linkedListLibrary.InsertNode(head1, 9);
        head1 = linkedListLibrary.InsertNode(head1, 4);
        head1 = linkedListLibrary.InsertNode(head1, 6);
        linkedListLibrary.DisplayNodes(head1); //64957

        Node head2 = null;
        head2 = linkedListLibrary.InsertNode(head2, 8);
        head2 = linkedListLibrary.InsertNode(head2, 4);
        linkedListLibrary.DisplayNodes(head2); //48

        Node head3 = AddLists(head1, head2);
        linkedListLibrary.DisplayNodes(head3); // 65005


    }

}
