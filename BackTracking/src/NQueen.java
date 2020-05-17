import java.util.ArrayList;


public class NQueen {

    /*
    [
    [".Q..",  // Solution 1
     "...Q",
     "Q...",
     "..Q."],

    ["..Q.",  // Solution 2
     "Q...",
     "...Q",
     ".Q.."]
    ]
    */
    public boolean isValid(ArrayList<Integer> colPlacement) {

        int rowId = colPlacement.size()-1;

        for(int i=0; i<rowId; i++) {
            int diff = Math.abs(colPlacement.get(rowId) - colPlacement.get(i));
            if(diff == 0 || (diff == (rowId - i))) {
                return false;
            }
        }
        return true;
    }

    public void nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        nQueenUtil(ans, new ArrayList<Integer>(), 0, n);
        printChessBoard(ans, n);
    }

    public void nQueenUtil(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> colPlacement, int row, int n) {
        if(row == n) {
            ans.add(new ArrayList<>(colPlacement));
            return;
        }

        for(int col=0; col<n; col++) {

            // choose
            colPlacement.add(col);

            //explore
            if(isValid(colPlacement)) {
                nQueenUtil(ans, colPlacement, row+1, n);
            }


            // un-choose
            colPlacement.remove(colPlacement.size()-1);

        }
    }

    public void printChessBoard(ArrayList<ArrayList<Integer>> ans, int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

        // conversion
        for(int i=0; i<ans.size(); i++) {
            ArrayList<String> temp = new ArrayList<>();
            for(int j=0; j<ans.get(i).size(); j++) {
                int val = ans.get(i).get(j);

                StringBuilder txt = new StringBuilder("");
                for(int k=0; k<4; k++) {
                    txt.append(".");
                }

                txt.setCharAt(val, 'Q');
                temp.add(txt.toString());
            }
            res.add(temp);
        }

        //print
        for(int i=0; i<res.size(); i++) {
            for(String x : res.get(i) ) {
                System.out.println(x + " ");
            }
            System.out.println();
        }
    }

    public void testNQueen() {
        nQueen(4);
    }

}
