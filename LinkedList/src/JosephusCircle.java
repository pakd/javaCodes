public class JosephusCircle {


    public Node makeCircular(Node head) {

        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return head;
    }
    public Node findLastNode(Node head, int k) {

        Node ptr = head;
        Node prev = head;

        while (ptr.next != ptr) {

            int count = 1;
            while(count != k) {
                prev = ptr;
                ptr = ptr.next;
                count++;
            }

            System.out.println("deleted node : " + ptr.data);
            prev.next = ptr.next;
            ptr = prev.next;
        }
        return ptr;

    }

    public void test_josephus_circle() {
        LinkedListLibrary linkedListLibrary = new LinkedListLibrary();
        Node head = null;
        for(int i=1; i<=14 ; i++) {
            head = linkedListLibrary.InsertNode(head, i);
        }

        head = makeCircular(head);
        Node ans = findLastNode(head, 2);
        System.out.println("last node : " + ans.data);
    }
}
