import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairsCloseToTarget {



    PairsCloseToTarget() {

        int[][] a = {{1, 8}, {2, 15}, {3, 9}};
        int[][] b = {{1, 8}, {2, 11}, {3, 12}};

        int target = 20;



        List<int[]> ans = getPairs(a, b, target);

        System.out.println("First Case : ");
        for(int[] x : ans) {
            System.out.println(x[0] + " " + x[1]);
        }

        int[][] a2 = {{1, 8}, {2, 7}, {3, 14}};
        int[][] b2 = {{1, 5}, {2, 10}, {3, 14}};
        target = 20;

        List<int[]> ans2 = getPairs(a2, b2, target);

        System.out.println("Second Case : ");
        for(int[] x : ans2) {
            System.out.println(x[0] + " " + x[1]);
        }


    }

    private List<int[]> getPairs(int[][] a, int[][] b, int target) {

        List<int[]> listA = new ArrayList<>();
        List<int[]> listB = new ArrayList<>();

        for(int[] x : a) {
            listA.add(x);
        }
        for(int[] x : b) {
            listB.add(x);
        }

        Collections.sort(listA, (i, j) -> i[1] - j[1]);
        Collections.sort(listB, (i, j) -> i[1] - j[1]);

        int l = 0;
        int r = b.length-1;

        List<int[]> ans = new ArrayList<>();
        int currDiff = Integer.MAX_VALUE;

        while(l < a.length && r >=0) {

            int sum = listA.get(l)[1] + listB.get(r)[1];

            if(sum > target) {
                r--;
            } else {
                if( (target - sum) == currDiff) {
                    ans.add(new int[]{listA.get(l)[0], listB.get(r)[0]});
                } else if(target - sum < currDiff) {
                    currDiff = target - sum;
                    ans.clear();
                    ans.add(new int[]{listA.get(l)[0], listB.get(r)[0]});
                }
                l++;
            }
        }

        return ans;
    }
}
