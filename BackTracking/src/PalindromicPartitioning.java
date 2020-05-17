import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitioning {

    /*
    s = "aab",
     [
    ["a","a","b"]
    ["aa","b"],
    ]
    */

    // to check if string is palindrome or not
    private boolean isPalindrome(String A){

        int i=0;
        int j = A.length()-1;
        while(i < j) {
            if(A.charAt(i) != A.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public void generatePalindromicPartitioning(String A) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        ArrayList<String> curr = new ArrayList<>();

        generatePalindromicPartitioningUtil(A, ans, curr, 0);

        printListOfList(ans);
    }


    public void generatePalindromicPartitioningUtil(String A, ArrayList<ArrayList<String>> ans, ArrayList<String> curr, int index) {
        if(index == A.length()) {
            ans.add(new ArrayList<String>(curr));
            return;

        }

        for(int i=index; i<A.length(); i++) {
            String temp = A.substring(index, i+1);

            // choose
            curr.add(temp);

            // explore
            if(isPalindrome(temp)) {
                generatePalindromicPartitioningUtil(A, ans, curr, i+1);
            }

            // un-choose
            curr.remove(curr.size()-1);

        }

    }

    public void printListOfList(List<ArrayList<String>> list) {
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }


    public void testPalindromicPartitioning() {

        String A = "aab";
        generatePalindromicPartitioning(A);

    }
}
