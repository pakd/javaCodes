package Sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStream {

    public void median_of_stream(double[] arr) {

        PriorityQueue<Double> minHeap = new PriorityQueue<>();

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int)(o2-o1);
            }
        });

        int n = arr.length;
        double median = arr[0];
        maxHeap.add(arr[0]);
        System.out.println(median);


        for(int i=1; i<n; i++) {

            double x = arr[i];

            if(maxHeap.size() > minHeap.size()) {
                if(x > median) {
                    minHeap.add(x);
                } else {
                    minHeap.add(maxHeap.peek());
                    maxHeap.remove();
                    maxHeap.add(x);

                }
                median = (minHeap.peek() + maxHeap.peek())/2;

            } else if(minHeap.size() == maxHeap.size()) {
                if(x > median) {
                    minHeap.add(x);
                    median = minHeap.peek();
                } else {
                    maxHeap.add(x);
                    median = maxHeap.peek();
                }
            } else {
                if(x > median) {
                    maxHeap.add(minHeap.peek());
                    minHeap.remove();
                    minHeap.add(x);
                } else {
                    maxHeap.add(x);
                }
                median = (minHeap.peek() + maxHeap.peek())/2;
            }

            System.out.println(median);
        }


    }

    public void test() {
        double[] arr = {5, 15, 10, 20, 3};
        median_of_stream(arr);
    }
}
