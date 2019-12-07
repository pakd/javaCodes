package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MinimumSwapsForSortedArray {

    class Node{
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    List<Node> list;

    public int find_minimum_no_of_swaps(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {
            list.add(new Node(arr[i], i));
        }

        int ans = 0;

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);


        for(int i=0; i<n; i++) {

            if(visited[i] == true || list.get(i).index == i) {
                continue;
            }

            int cycle_size = 0;
            int j = i;

            while(!visited[j]) {
                visited[j] = true;
                cycle_size++;
                j = list.get(j).index;

            }

            if(cycle_size > 0) {

                ans += (cycle_size -1);
            }

        }

        return ans;
    }


    public void test() {

        int[] arr = {1,5,4,3,2};

        list = new LinkedList<>();
        System.out.println(find_minimum_no_of_swaps(arr));
    }
}
