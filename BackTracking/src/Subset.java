import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Subset {


    /*
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    Also, the subsets should be sorted in ascending ( lexicographic ) order.
    The list is not necessarily sorted.

    S = [1,2,3]
    [
      [],
      [1],
      [1, 2],
      [1, 2, 3],
      [1, 3],
      [2],
      [2, 3],
      [3],
    ]
    */

    public void generateAllSubsets(int[] arr) {


        int n = arr.length;
        int N = (int)Math.pow(2, n);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0; i<N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0; j<n; j++) {
                if(((i >> j) & 1) == 1) {
                    //System.out.print(arr[j] + " ");
                    list.add(arr[j]);
                }
            }
            ans.add(list);
        }
        printListOfList(ans);

        //sort logic

        ans.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for(int i=0; i<Math.min(o1.size(), o2.size()); i++) {
                    int c = o1.get(i) - o2.get(i);
                    if(c!=0) {
                        return c;
                    }
                }
                return o1.size() - o2.size();
            }
        });

        printListOfList(ans);
    }


    public void printListOfList(List<ArrayList<Integer>> list) {
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void testGenerateAllSubsets() {
        int[] arr = {1,2, 3};
        generateAllSubsets(arr);
    }
}
