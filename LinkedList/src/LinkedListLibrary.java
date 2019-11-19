public class LinkedListLibrary {

    public void DisplayNodes(Node head) {
        Node current = head;
        System.out.print("nodes in list : ");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void test_display() {
        Node p = new Node(1);
        p.next = new Node(2);
        p.next.next = new Node(3);
        p.next.next.next = new Node(4);
        DisplayNodes(p);
    }

    public int CountNodes(Node head) {
        Node current = head;
        int count = 0;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void test_count_nodes() {
        Node p = new Node(1);
        p.next = new Node(2);
        p.next.next = new Node(3);
        p.next.next.next = new Node(4);
        p.next.next.next.next = new Node(5);
        System.out.println("total no of nodes in linked list : " + CountNodes(p));
    }

    public Node InsertNode(Node head, int d) {
        Node newNode = new Node(d);
        if(head == null) {
            return newNode;
        }
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    public void test_insert_node() {
        Node p = new Node(1);
        p.next = new Node(2);
        p.next.next = new Node(3);
        // Node p = null;
        DisplayNodes(p);
        p = InsertNode(p, 4);
        DisplayNodes(p);
    }

}
