import java.util.*;

public class LRUCache {


    LRUCache(int size) {
        this.capacity = size;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

    }
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    // Boundary Nodes
    public Node head;
    public Node tail;

    Map<Integer, Node> map;

    int capacity;
    int count = 0;


    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    // return value
    public int get(int key) {
        if(map.containsKey(key) == true) {
            Node node = map.get(key);
            int result = node.value;

            deleteNode(node);
            addToHead(node);

            System.out.println("Key found!");
            return result;
        } else {
            System.out.println("Key not found!");
            return -1;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key) == true) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);

            if(count < capacity) {
                addToHead(node);
                count++;
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);

            }

        }
    }
}
