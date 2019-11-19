public class FindMiddleNode {

    public Node Find(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void test_find_middle_node() {
        Node p = new Node(1);
        p.next = new Node(2);
        p.next.next = new Node(3);
        p.next.next.next = new Node(4);
        p.next.next.next = new Node(5);

        Node middle = Find(p);
        System.out.println("middle " + middle.data);
    }
}
