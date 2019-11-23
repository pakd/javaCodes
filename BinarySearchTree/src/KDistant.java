import java.util.ArrayList;
import java.util.List;

public class KDistant {

    public void FindKDistantNodesFromRoot(Node root, int k) {
        if(root == null) {
            return;
        }
        if(k == 0) {
            System.out.print(root.data + " ");
            return;
        }
        FindKDistantNodesFromRoot(root.left, k-1);
        FindKDistantNodesFromRoot(root.right, k-1);
    }

    public void test_k_distant_from_root() {
        BSTLibrary bstLibrary = new BSTLibrary();
        int[] arr = {20,14, 24, 10, 18, 22, 27, 17};
        Node root = null;
        for(int x : arr) {
            root = bstLibrary.Insert(root, x);
        }

        FindKDistantNodesFromRoot(root, 1);
        System.out.println();
        FindKDistantNodesFromRoot(root, 2);
        System.out.println();
        FindKDistantNodesFromRoot(root,3);
        System.out.println();
        FindKDistantNodesFromRoot(root,4);
    }

    //------X---------X-------------------------X-------------------X---
    List<Node> NodePath;
    public void FindKDistantNodesFromRootWithFilter(Node root, int k) {
        if(root == null) {
            return;
        }
        if(k == 0) {
            System.out.print(root.data + " ");
            return;
        }
        if(root.left != null && isExistInPath(root.left.data) == false) {
            FindKDistantNodesFromRootWithFilter(root.left, k-1);
        }
        if(root.right != null && isExistInPath(root.right.data) == false) {
            FindKDistantNodesFromRootWithFilter(root.right, k-1);
        }
    }


    public boolean isPathToNodeX(Node root, int x) {
        if(root == null) {
            return false;
        }
        NodePath.add(root);
        if(x == root.data) {
            return true;
        }
        if(isPathToNodeX(root.left, x) || isPathToNodeX(root.right, x)) {
            return true;
        }
        NodePath.remove(NodePath.size()-1);
        return false;
    }

    public boolean isExistInPath(int key) {
        for(Node x : NodePath) {
            if(key == x.data) {
                return true;
            }
        }
        return false;
    }

    public void test_k_distant_nodes_from_given_node() {
        int k = 3;
        int nodeX = 30;
        int[] arr = {40,20,50,15,30,60,10,24,36,38,37};
        Node root = null;
        BSTLibrary bstLibrary = new BSTLibrary();
        for(int x : arr) {
            root = bstLibrary.Insert(root, x);
        }
        NodePath = new ArrayList<>();
        boolean isPath = isPathToNodeX(root, nodeX);
        if(isPath) {
            System.out.print("Path to Node X : ");
            for(Node x : NodePath) {
                System.out.print(x.data + " ");
            }
            System.out.println();
        }

        int j = NodePath.size() - 1;
        System.out.println("Nodes at distance k from given node");
        while(j >= 0) {
            //System.out.println("calling J: " + NodePath.get(j).data + " K : " + k);
            FindKDistantNodesFromRootWithFilter(NodePath.get(j), k);
            j--;
            k--;

        }
    }
}
