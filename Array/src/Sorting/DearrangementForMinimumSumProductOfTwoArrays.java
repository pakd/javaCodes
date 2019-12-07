package Sorting;


import java.util.*;

public class DearrangementForMinimumSumProductOfTwoArrays {


    public void reverse(int[] arr) {
        int n = arr.length;

        int i = 0;
        int j = n-1;

        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public int no_of_dearrangements(int[] arr1, int[] arr2) {
        int[] clone_arr1 = arr1.clone();
        int[] clone_arr2 = arr2.clone();

        Arrays.sort(clone_arr1);
        Arrays.sort(clone_arr2);
        reverse(clone_arr2);

//        for(int i : clone_arr2) {
//            System.out.print(i + " ");
//        }

        int n = arr1.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(clone_arr1[i], clone_arr2[i]);
        }

        int count = 0;

        for(int i=0; i<n; i++) {

            if(arr2[i] != map.get(arr1[i])) {
                count++;
            }
        }

        return count;
    }


    public void test() {

        int[] A = {1, 2, 3, 4};
        int[] B = {6, 3, 4, 5};
        System.out.println(no_of_dearrangements(A, B));
    }
}
