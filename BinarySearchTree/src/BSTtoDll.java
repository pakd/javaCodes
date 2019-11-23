public class BSTtoDll {


    public Node prev = null;
    public Node head = null;
    public void convertBSTtoDll(Node root)
    {
        if(root == null) {
            return;
        }

        convertBSTtoDll(root.left);
        if(prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        convertBSTtoDll(root.right);
    }

    public void test() {
        int[] arr = {100,50,150,30,60,120,180,170,210};
        Node root = null;
        BSTLibrary bstLibrary = new BSTLibrary();
        for(int x : arr) {
            root = bstLibrary.Insert(root, x);
        }

        convertBSTtoDll(root);

        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
}
