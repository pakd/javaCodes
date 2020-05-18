import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    /**
     * s = [1,2,3]
     * 1. "123"
     * 2. "132"
     * 3. "213"
     * 4. "231"
     * 5. "312"
     * 6. "321"
     *
     * add count variable if you want to find kth permutation sequence
     */

    public void generatePermutationSequence(int n) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        generatePermutationSequenceUtil(list, new ArrayList<>(), ans);

        printListOfList(ans);

    }

    public void generatePermutationSequenceUtil(ArrayList<Integer> suffix, ArrayList<Integer> prefix, ArrayList<ArrayList<Integer>> ans ) {

        if(suffix.size() == 0) {
            ans.add(new ArrayList<>(prefix));
            return;
        }

        for(int i=0; i<suffix.size(); i++) {
            //choose
            prefix.add(suffix.get(i));
            ArrayList<Integer> suffixCopy = new ArrayList<>(suffix);
            suffixCopy.remove(i);

            //explore
            generatePermutationSequenceUtil(suffixCopy, prefix, ans);

            //un-choose
            prefix.remove(suffix.get(i));
        }
    }

    public void printListOfList(List<ArrayList<Integer>> list) {
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
            }
            System.out.println();
        }
    }
    public void testGeneratePermutationSequence() {
        generatePermutationSequence(4);
    }
}
