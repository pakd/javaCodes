public class MergeTwoSortedLinkedLists {


    private Node last = null;
    private Node InsertNode(Node head, Node push) {
        if(last == null) {
            head = push;
            last = head;
        } else {
            last.next = push;
            last = last.next;
        }
        return head;
    }

    public Node Merge(Node head1, Node head2) {
        Node head3 = null;

        while(head1 != null || head2 != null) {
            int data1 = (head1 != null)? head1.data : Integer.MAX_VALUE;
            int data2 = (head2 != null)? head2.data : Integer.MAX_VALUE;

            if(data1 < data2) {
                head3 = InsertNode(head3, head1);
                head1 = head1.next;
            } else {
                head3 = InsertNode(head3, head2);
                head2 = head2.next;
            }
        }
        return head3;
    }

    public void test_merge() {
        Node p = new Node(2);
        p.next = new Node(5);
        p.next.next = new Node(10);
        p.next.next.next = new Node(15);

        Node q = new Node(3);
        q.next = new Node(7);
        q.next.next = new Node(18);

        Node r = Merge(p, q);
        LinkedListLibrary linkedListLibrary = new LinkedListLibrary();
        linkedListLibrary.DisplayNodes(r);
    }
}
