package RangeQuery;

public class SegmentTree {

    void constructSTUtil(int[] arr, int[] tree, int start, int end, int treeNode) {

        if(start == end) {
            tree[treeNode] = arr[start];
            return;
        }

        int mid = (start + end)/2;

        constructSTUtil(arr, tree, start, mid, 2*treeNode+1);
        constructSTUtil(arr, tree, mid+1, end, 2*treeNode+2);

        tree[treeNode] = tree[2*treeNode+1] + tree[2*treeNode+2];
        return;
    }

    int findRangeSum(int[] tree, int qStart, int qEnd, int start, int end, int treeNode) {

        // total overlap
        if(qStart <= start && end <= qEnd) {
            return tree[treeNode];
        }

        // no overlap
        if(qStart > end || qEnd < start) {
            return 0;
        }

        int mid = (start + end)/2;

        int leftSubTree = findRangeSum(tree, qStart, qEnd, start, mid, 2*treeNode+1);
        int rightSubTee = findRangeSum(tree, qStart, qEnd, mid+1, end, 2*treeNode+2);

        return leftSubTree+rightSubTee;
    }

    void updateValue(int[] tree, int index, int diff, int start, int end, int treeNode) {
        // no overlaps
        if(index < start || index > end) {
            return;
        }

        tree[treeNode] += diff;

        // partial overlaps
        if(start != end) {
            int mid = (start+end)/2;
            updateValue(tree, index, diff, start, mid, 2*treeNode+1);
            updateValue(tree, index, diff, mid+1, end, 2*treeNode+2);
        }
    }



    public void test() {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int n = arr.length;
        int[] tree = new int[2*n];

        constructSTUtil(arr, tree, 0, n-1, 0);


        for(int i : tree) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(findRangeSum(tree, 4, 6, 0, n-1, 0));

        arr[5] = 8;
        int diff = 2; // positive = 2;
        int index = 5;

        updateValue(tree, index, diff, 0, n-1, 0);
        System.out.println(findRangeSum(tree, 4, 6, 0, n-1, 0));

    }


}
