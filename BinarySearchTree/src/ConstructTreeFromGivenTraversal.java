public class ConstructTreeFromGivenTraversal {

    public int search(int[] arr, int start, int end, int key) {
        for(int i = start; i <= end; i++ ) {
            if(arr[i] == key) {
                return i;
            }
        }
            return -1;
    }

    public Node ConstructTreeFromPreorderAndInorder(int[] in, int inS, int inE, int[] pre, int preS, int preE) {
        if(inS > inE) {
            return null;
        }
        Node root = new Node(pre[preS]);

        int index = search(in, inS, inE, root.data);

        int lInS = inS;
        int lInE = index - 1;
        int rInS = index + 1;
        int rInE = inE;
        int lPreS = preS + 1;
        int lPreE = lInE - lInS + lPreS;
        int rPreS = lPreE + 1;
        int rPreE = preE;
        root.left = ConstructTreeFromPreorderAndInorder(in, lInS, lInE, pre, lPreS, lPreE );
        root.right = ConstructTreeFromPreorderAndInorder(in, rInS, rInE, pre, rPreS, rPreE );
        return root;


    }

    public void test() {
        int[] inorder = {7,4,5,8,4,10,9,6};
        int[] preorder = {10,4,7,8,5,4,6,9};
        int size = 8;
        Node root = ConstructTreeFromPreorderAndInorder(inorder, 0, size-1, preorder, 0, size -1 );

        BSTLibrary bstLibrary = new BSTLibrary();
        bstLibrary.DisplayInorder(root);
    }
}
