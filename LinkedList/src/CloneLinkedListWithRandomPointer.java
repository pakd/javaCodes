import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandomPointer {


    private void DisplayList(NodeR head) {
        while(head != null) {
            int arbit_data = (head.random != null)? head.random.data : -1;
            System.out.println(head.data + " " + arbit_data);
            head = head.next;
        }
    }
    private NodeR cloneList(NodeR head) {
        NodeR originalNode = head;

        Map<NodeR, NodeR> map = new HashMap<>();
        NodeR cloneNode = null;
        while(originalNode != null) {
            cloneNode = new NodeR(originalNode.data);
            map.put(originalNode, cloneNode);
            originalNode = originalNode.next;
        }
        originalNode = head;

        while(originalNode != null) {
            cloneNode = map.get(originalNode);
            cloneNode.next = map.get(originalNode.next);
            cloneNode.random = map.get(originalNode.random);
            originalNode = originalNode.next;
        }

        return map.get(head);
    }

    public void test_clone_list() {
        NodeR p = new NodeR(1);
        p.next = new NodeR(2);
        p.next.next = new NodeR(3);
        p.next.next.next = new NodeR(4);
        p.next.next.next.next = new NodeR(5);

        p.random = p.next.next;
        p.next.random = p.next.next.next;
        p.next.next.random = p.next.next.next.next;
        p.next.next.next.random = null;
        p.next.next.next.next.random = p.next;

        System.out.println("Original List : ");
        DisplayList(p);

        NodeR q = cloneList(p);

        System.out.println("Cloned List : ");
        DisplayList(q);

    }
}
