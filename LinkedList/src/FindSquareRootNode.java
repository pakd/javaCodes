public class FindSquareRootNode {

    public Node Find(Node head) {
        Node square_root_node = null;

        int i = 1;
        int j = 1;
        while(head != null) {
            if(i == j*j) {
                if(square_root_node == null) {
                    square_root_node = head;
                } else {
                    square_root_node = square_root_node.next;
                }
                j++;
            }
            head = head.next;
            i++;
        }
        return square_root_node;
    }

    public void test_find_square_root_node() {
        Node p = new Node(1);
        p.next = new Node(2);
        p.next.next = new Node(3);
        p.next.next.next = new Node(4);
        p.next.next.next.next = new Node(5);
        p.next.next.next.next.next = new Node(6);
        p.next.next.next.next.next.next = new Node(7);
        p.next.next.next.next.next.next = new Node(7);
        p.next.next.next.next.next.next.next = new Node(8);
        p.next.next.next.next.next.next.next.next = new Node(9);
        p.next.next.next.next.next.next.next.next.next = new Node(10);

        Node square_root = Find(p);
        System.out.println("square_root_nth_node : " + square_root.data);



    }
}
