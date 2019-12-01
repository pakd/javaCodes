public class SearchInSortedMatrix {

    public boolean search(int[][] mat, int key) {

        int i = 0;
        int size = mat.length;
        int j = size-1;

        while( i<size && j >=0 ) {
            if(mat[i][j] == key) {
                return true;
            }
            else if(mat[i][j] < key) {
                i++;
            } else {
                j--;
            }
        }
        return false;

    }

    public void test() {

        // assuming r = c matrix
        int[][] mat = {
                        {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50}
                      };

        System.out.println(search(mat, 29));
        System.out.println(search(mat, 28));
    }
}
