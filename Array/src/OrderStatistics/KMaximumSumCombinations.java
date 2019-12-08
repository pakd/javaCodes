package OrderStatistics;

import java.util.*;

public class KMaximumSumCombinations {
    public class Node {
        int value;
        int first;
        int second;

        public Node(int value, int first, int second) {
            this.value = value;
            this.first = first;
            this.second = second;
        }
    }


    int prime = 23;
    public int encode(int row, int col) {
        return (row*prime + col);
    }
//    public int[] decode(int val) {
//        int[] res = new int[2];
//        res[0] = val/prime;
//        res[1] = val%prime;
//        return res;
//    }

    public void findKMaximumSums(int[] A, int[] B, int k) {

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value - o1.value;
            }
        });

        Set<Integer> set = new TreeSet<>();

        int n = A.length;
        int sum = A[n-1] + B[n-1];
        pq.add(new Node(sum, n-1, n-1));
        set.add(encode(n-1,n-1));

        int count = 0;
        while(!pq.isEmpty() && count < k) {

            Node top = pq.remove();
            System.out.println(A[top.first] + "+" + B[top.second] + "=" + top.value);
            count++;

            // left
            if(top.first>0 && top.second>0 && !set.contains(encode(top.first-1,top.second))) {
                pq.add(new Node(A[top.first-1] + B[top.second], top.first-1, top.second));
                set.add(encode(top.first-1, top.second));
            }

            // right
            if(top.first>0 && top.second>0 && !set.contains(encode(top.first,top.second-1))) {
                pq.add(new Node(A[top.first] + B[top.second-1], top.first, top.second-1));
                set.add(encode(top.first, top.second-1));
            }

        }
    }


    public void test() {
        int[] A = { 1, 4, 2, 3 };
        int[] B = { 2, 5, 1, 6 };

        Arrays.sort(A);
        Arrays.sort(B);

        findKMaximumSums(A, B, 5);

    }
}
