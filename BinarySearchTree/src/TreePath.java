import java.util.ArrayList;
import java.util.List;

public class TreePath {

    public List<Integer> path;
    public void PrintAllPathToLeaf(Node root) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            for(Integer x : path) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        PrintAllPathToLeaf(root.left);
        PrintAllPathToLeaf(root.right);
        path.remove(path.size()-1);
    }

    public boolean isPathToNodeX(Node root, int x) {
        if(root == null) {
            return false;
        }

        path.add(root.data);
        if(root.data == x) {
            return true;
        }

        if(isPathToNodeX(root.left, x) || isPathToNodeX(root.right, x)) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public void test_print_all_paths() {
        BSTLibrary bstLibrary = new BSTLibrary();
        int[] arr = {20,14, 24, 10, 18, 22, 27, 17};
        Node root = null;
        for(int x : arr) {
            root = bstLibrary.Insert(root, x);
        }
        path  = new ArrayList<>();
        PrintAllPathToLeaf(root);

        path.clear();
        System.out.println();
        boolean isPath = isPathToNodeX(root, 17);

        if(isPath == true) {
            for(Integer x : path) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            System.out.println("not found");
        }


    }

}
