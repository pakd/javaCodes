public class LowestCommonAncestor {

    public Node findLCA(Node root, Node p, Node q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }
        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }
        return (left != null)? left : right;
    }

    // assuming node will exist always in tree
    public void test_find_lca() {
        int[] arr = {22, 10, 30, 5, 15, 24, 36, 23};
        Node root = null;
        BSTLibrary bstLibrary = new BSTLibrary();
        for(int x : arr) {
            root = bstLibrary.Insert(root, x);
        }
        Node ans = findLCA(root,bstLibrary.SearchRecursive(root,36), bstLibrary.SearchRecursive(root,23) );
        System.out.println("LCA : " + ans.data);
    }
}
