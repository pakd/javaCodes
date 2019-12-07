package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortArrayByFrequencyMaintainingOrder {

    public void sort(int[] in_arr) {

        int n = in_arr.length;

        Integer[] arr = new Integer[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.valueOf(in_arr[i]);
        }



        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();

        for(int i=0; i<n; i++) {
            int count = (freqMap.containsKey(arr[i]))? freqMap.get(arr[i]):0;
            freqMap.put(arr[i], count+1);

            if(indexMap.containsKey(arr[i]) == false) {
                indexMap.put(arr[i], i);
            }
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int freq1 = freqMap.get(o1);
                int freq2 = freqMap.get(o2);

                if(freq2 != freq1) {
                    return freq2 - freq1;
                } else {
                    return indexMap.get(o1) - indexMap.get(o2);
                }

            }
        });


        for(int i=0; i<n; i++) {
            in_arr[i] = arr[i];
        }

    }

    public void test() {
        int[] arr = {3,2,3,1,1,2,3,2,3,1,5,4,6,6};
        sort(arr);

        for(Integer j : arr) {
            System.out.print(j + " ");
        }
    }
}
