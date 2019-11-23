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



    List<Node> nodePath;
    public boolean reversePathToNodeX(Node root, int x) {
        if(root == null) {
            return false;
        }

        nodePath.add(root);
        if(root.data == x) {
            return true;
        }

        if(reversePathToNodeX(root.left, x) || reversePathToNodeX(root.right, x)) {
            return true;
        }
        nodePath.remove(nodePath.size()-1);
        return false;
    }

    int sum = 0;
    public boolean isFindRootToLeafGivenSum(Node root, int x) {
        if(root == null) {
            return false;
        }
        sum += root.data;
        path.add(root.data);
        if(sum == x) {
            System.out.print("sum made " + x + " by : " );
            for(Integer itr : path) {
                System.out.print(itr + " ");
            }
            System.out.println();
            return true;
        }
        if(isFindRootToLeafGivenSum(root.left, x) || isFindRootToLeafGivenSum(root.right, x)) {
            return true;
        }
        path.remove(path.size()-1);
        sum -= root.data;
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

        path.clear();
        isPath = isFindRootToLeafGivenSum(root, 66);


    }

    public void test_reverse_path_to_node_x() {
        BSTLibrary bstLibrary = new BSTLibrary();
        int[] arr2 = {20,14, 24, 10, 18, 22, 27, 17};
        Node root2 = null;
        for(int x : arr2) {
            root2 = bstLibrary.Insert(root2, x);
        }
        nodePath  = new ArrayList<>();
        reversePathToNodeX(root2, 17);

        // assuming true

        int i = 0;
        int j = nodePath.size()-1;

        while(i < j) {
            Node nodeI = nodePath.get(i);
            Node nodeJ = nodePath.get(j);
            int temp = nodeI.data;
            nodeI.data = nodeJ.data;
            nodeJ.data = temp;
            i++;
            j--;
        }
        bstLibrary.DisplayLevelOrder(root2);
    }

}
