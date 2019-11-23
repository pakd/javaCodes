import java.util.Stack;

class PairNode {
    public Node node;
    public int state;
    PairNode(Node node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class IterativeTraversals {


    public void Inorder(Node root) {
        if(root == null) {
            return;
        }
        Stack<PairNode> st = new Stack<>();
        st.push(new PairNode(root, 0));

        while(st.isEmpty() == false) {
            PairNode temp = st.peek();
            int state = temp.state;

            st.pop();

            if(state == 3 || temp.node == null) {
                continue;
            }
            st.push(new PairNode(temp.node, state+1));

            if(state == 0) {
                st.push(new PairNode(temp.node.left, 0));
            } else if(state == 1) {
                System.out.print(temp.node.data + " ");
            } else if(state == 2) {
                st.push(new PairNode(temp.node.right, 0));
            }


        }
    }
    public void Preorder(Node root) {
        if(root == null) {
            return;
        }
        Stack<PairNode> st = new Stack<>();
        st.push(new PairNode(root, 0));

        while(st.isEmpty() == false) {
            PairNode temp = st.peek();
            int state = temp.state;

            st.pop();

            if(state == 3 || temp.node == null) {
                continue;
            }
            st.push(new PairNode(temp.node, state+1));

            if(state == 0) {
                System.out.print(temp.node.data + " ");
            } else if(state == 1) {
                st.push(new PairNode(temp.node.left, 0));
            } else if(state == 2) {
                st.push(new PairNode(temp.node.right, 0));
            }


        }
    }

    public void Postorder(Node root) {
        if(root == null) {
            return;
        }
        Stack<PairNode> st = new Stack<>();
        st.push(new PairNode(root, 0));

        while(st.isEmpty() == false) {
            PairNode temp = st.peek();
            int state = temp.state;

            st.pop();

            if(state == 3 || temp.node == null) {
                continue;
            }
            st.push(new PairNode(temp.node, state+1));

            if(state == 0) {
                st.push(new PairNode(temp.node.left, 0));
            } else if(state == 1) {
                st.push(new PairNode(temp.node.right, 0));
            } else if(state == 2) {
                System.out.print(temp.node.data + " ");
            }


        }
    }

    public void test() {
        int[] arr = {10, 6, 14, 4, 8, 12, 16};
        Node root = null;
        BSTLibrary bstLibrary = new BSTLibrary();
        for(int x : arr) {
            root = bstLibrary.Insert(root, x);
        }
        System.out.println("Inorder Traversal : ");
        Inorder(root);
        System.out.println();

        System.out.println("PreOrder Traversal : ");
        Preorder(root);
        System.out.println();

        System.out.println("PostOrder Traversal : ");
        Postorder(root);


    }


}
