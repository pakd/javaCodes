import java.security.KeyPair;
import java.util.*;

class Pair {
    public Node node;
    public int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
public class TreeViews {

    public int maxLevel = 0;
    public void DisplayLeftView(Node root, int level) {
        if(root == null) {
            return;
        }
        if(level > maxLevel) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        DisplayLeftView(root.left, level+1);
        DisplayLeftView(root.right, level+1);
    }

    public int maxLevel2 = 0;
    public void DisplayRightView(Node root, int level) {
        if(root == null) {
            return;
        }
        if(level > maxLevel2) {
            System.out.print(root.data + " ");
            maxLevel2 = level;
        }
        DisplayRightView(root.right, level+1);
        DisplayRightView(root.left, level+1);
    }

    public void DisplayVerticalView(Node root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(root, 0));

        while(Q.isEmpty() != true) {
            Pair temp = Q.peek();
            if(map.containsKey(temp.hd)) {
                map.get(temp.hd).add(temp.node.data);
            } else {
                map.put(temp.hd, new ArrayList<>());
                map.get(temp.hd).add(temp.node.data);
            }

            Q.remove();
            if(temp.node.left != null) {
                Q.add(new Pair(temp.node.left, temp.hd-1));
            }
            if(temp.node.right != null) {
                Q.add(new Pair(temp.node.right, temp.hd+1));
            }

        }

        for( Integer x : map.keySet()) {
            System.out.print(x + " : ");
            map.get()
            for( Integer y : map.get(x)) {
                System.out.print( y + " ");
            }
            System.out.println();

        }

        // top view : print first element only of list
        // map.get(x).get(0)
        // bottom view : print last element only of list
        // map.get(x).get(listsize - 1)

    }



    public void test_view() {
        BSTLibrary bstLibrary = new BSTLibrary();
        int[] arr = {20,14, 24, 10, 18, 22, 27, 17};
        Node root = null;
        for(int x : arr) {
            root = bstLibrary.Insert(root, x);
        }
        DisplayLeftView(root, 1);
        System.out.println();
        DisplayRightView(root, 1);
        System.out.println();

        DisplayVerticalView(root);
    }
}
