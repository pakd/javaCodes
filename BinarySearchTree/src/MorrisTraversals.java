public class MorrisTraversals {

    public void Inorder(Node root) {

        if(root == null) return;

        Node curr = root;

        while(curr != null) {

            if(curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;

            } else {
                Node pre = curr.left;

                while (pre != null && (pre.right != null && pre.right != curr)) {
                    pre = pre.right;
                }

                if(pre.right == null) { // link formation
                    pre.right = curr;
                    curr = curr.left;
                } else { // link break
                    pre.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right; // left subtree is already printed
                }
            }
        }
    }

    public void Preorder(Node root) {

        if(root == null) return;

        Node curr = root;

        while(curr != null) {

            if(curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;

            } else {
                Node pre = curr.left;

                while (pre != null && (pre.right != null && pre.right != curr)) {
                    pre = pre.right;
                }

                if(pre.right == null) { // link formation
                    System.out.print(curr.data + " ");
                    pre.right = curr;
                    curr = curr.left;
                } else { // link break
                    pre.right = null;

                    curr = curr.right; // left subtree is already printed
                }
            }
        }


    }

    public void test() {
        int[] arr = {100,50,150,30,60,120,180,170,210};
        Node root = null;
        BSTLibrary bstLibrary = new BSTLibrary();
        for(int x : arr) {
            root = bstLibrary.Insert(root, x);
        }
        Inorder(root);
        System.out.println();
        Preorder(root);
    }
}
