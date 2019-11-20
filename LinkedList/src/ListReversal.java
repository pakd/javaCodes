public class ListReversal {

    public Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node head = null;

    public void reverse_recursive(Node p) {
        if(p.next == null) {
            head = p;
            return;
        }
        reverse_recursive(p.next);
        Node q = p.next;
        q.next = p;
        p.next = null;
    }

    public Node reverse_recursive_in_block_of_k(Node head, int k) {
        Node curr = head;
        Node next = null;
        Node prev = null;
        int count = 0;


        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null) {
            head.next = reverse_recursive_in_block_of_k(next, k);
        }

        head = prev;
        return head;
    }

    public void test_reverse() {
        Node p = new Node(1);
        p.next = new Node(2);
        p.next.next = new Node(3);
        p.next.next.next = new Node(4);
        LinkedListLibrary linkedListLibrary = new LinkedListLibrary();
        linkedListLibrary.DisplayNodes(p);
        Node rev = reverse(p);
        linkedListLibrary.DisplayNodes(rev);


    }

    public void test_reverse_recursive() {
        System.out.println("test_reverse_recursive");
        Node q = new Node(4);
        q.next = new Node(5);
        q.next.next = new Node(6);
        q.next.next.next = new Node(8);
        LinkedListLibrary linkedListLibrary = new LinkedListLibrary();
        linkedListLibrary.DisplayNodes(q);
        reverse_recursive(q);
        linkedListLibrary.DisplayNodes(head);

    }

    public void test_reverse_recursive_in_block_of_k() {
        LinkedListLibrary linkedListLibrary = new LinkedListLibrary();
        Node head = null;
        for(int i=1; i<=10; i++) {
            head = linkedListLibrary.InsertNode(head, i);
        }
        linkedListLibrary.DisplayNodes(head);
        head = reverse_recursive_in_block_of_k(head, 3);
        linkedListLibrary.DisplayNodes(head);



    }
}
