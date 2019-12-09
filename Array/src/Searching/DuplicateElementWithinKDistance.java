package Searching;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElementWithinKDistance {

    public void findDuplicate(int[] arr, int k) {

        int n = arr.length;

        Set<Integer> set = new HashSet<>();


        for(int i=0; i<n; i++) {
            if(set.contains(arr[i])) {
                System.out.println(arr[i]);
            }
            set.add(arr[i]);

            if(i >= k) {
                set.remove(arr[i-k]);
            }
        }

    }

    public void test() {

        int[] arr = {1, 2, 3, 1, 4, 5, 4};

        findDuplicate(arr, 3);

    }
}
