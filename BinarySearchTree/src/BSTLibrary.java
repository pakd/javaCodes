import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTLibrary {

    public Node Insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        } else if(key < root.data){
            root.left = Insert(root.left, key);
        } else {
            root.right = Insert(root.right, key);
        }
        return root;
    }


    public void DisplayInorder(Node root) {
        if(root == null) {
            return;
        }
        DisplayInorder(root.left);
        System.out.print(root.data + " ");
        DisplayInorder(root.right);

    }

    public Node SearchRecursive(Node root, int key) {
        if(root == null || root.data == key) {
            return root;
        } else if (key < root.data) {
            return SearchRecursive(root.left, key);
        } else {
            return SearchRecursive(root.right, key);
        }
    }

    public void DisplayLevelOrder(Node root) {

        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.isEmpty() != true) {
            Node temp = q.peek();
            q.remove();

            System.out.print(temp.data + " ");
            if(temp.left != null) {
                q.add(temp.left);
            }
            if(temp.right != null) {
                q.add(temp.right);
            }

        }
    }


    public void testInsertRecursive() {
        int[] arr = {13, 3, 4, 12, 14, 10, 5, 1, 8, 2, 7, 9, 11, 6, 18};
        Node root = null;
        for( int x : arr) {
            root = Insert(root, x);
        }

        DisplayInorder(root);
    }

    public void testSearchRecursive() {
        int[] arr = {13, 3, 4, 12, 14, 10, 5, 1, 8, 2, 7, 9, 11, 6, 18};
        Node root = null;
        for( int x : arr) {
            root = Insert(root, x);
        }
        Node ans = SearchRecursive(root, 10);
        System.out.println(ans.data);
        ans = SearchRecursive(root, 40);
        System.out.println(ans);
    }

    public void testDisplayLevelOrder() {
        int[] arr = {13, 3, 4, 12, 14, 10, 5, 1, 8, 2, 7, 9, 11, 6, 18};
        Node root = null;
        for( int x : arr) {
            root = Insert(root, x);
        }

        DisplayLevelOrder(root);
    }
}
