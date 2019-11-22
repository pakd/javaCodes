public class BSTSizeUtils {


    public int GetHeight(Node root) {
        if(root == null) {
            return 0;
        }
        return (1 + Math.max(GetHeight(root.left), GetHeight(root.right)));
    }

    public int size = 0;
    public void GetSize(Node root) {
        if(root == null) {
            return;
        }
        size++;
        GetSize(root.left);
        GetSize(root.right);
    }

    public int GetMax(Node root) {
        if(root == null) {
            return 0;
        }
        return (Math.max(root.data, Math.max(  GetMax(root.left), GetMax(root.right) ) ) );
    }

    public int GetDiameter(Node root) {
        if(root == null) {
            return 0;
        }
        return ( Math.max(GetDiameter(root.left), Math.max(GetDiameter(root.right), 1 + GetHeight(root.left) + GetHeight(root.right))) );

    }

    public void testUtils() {
        BSTLibrary bstLibrary = new BSTLibrary();
        int[] arr = {20,14, 24, 10, 18, 22, 27, 17};
        Node root = null;
        for(int x : arr) {
            root = bstLibrary.Insert(root, x);
        }

        System.out.println("Height : " + GetHeight(root));

        GetSize(root);
        System.out.println("Size : " +size);

        System.out.println("Max : "+ GetMax(root));

        System.out.println("Diameter : " + GetDiameter(root));

    }


}
