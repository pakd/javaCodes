import java.sql.Array;
import java.util.*;

public class CombinationSum {



    /*
    S = [2, 3, 6, 7]
    [2, 2, 3]
    [7]
    */

    public void generateCombinationSum(ArrayList<Integer> arr, int sum) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generateCombinationSumUtil(arr, ans, sum, new ArrayList<>(), 0);

        printListOfList(ans);


    }


    public void generateCombinationSumUtil(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, int sum,  ArrayList<Integer> curr, int index) {
        if(sum == 0) {
            // all things are references so make sure to create copies
            if(!ans.contains(curr) ){
                ans.add(new ArrayList<Integer>(curr));
            }
            return;
        }

        for(int i=index; i<arr.size(); i++) {
            if(sum < arr.get(i)) {
                return;
            }

            // choose
            curr.add(arr.get(i));

            //explore
            generateCombinationSumUtil(arr, ans, sum - arr.get(i), curr, i);

            // un-choose
            curr.remove(curr.size()-1);
        }




    }

    public void printListOfList(List<ArrayList<Integer>> list) {
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }



    public void testGenerateCombinationSum() {
        int[] arr = {2, 3, 6, 7};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr) {
            list.add(i);
        }

        int sum = 7;
        generateCombinationSum(list, sum);

    }


}
