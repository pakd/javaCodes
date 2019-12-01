public class NQueues {

    int[] arr;
    int[] frontIndex;
    int[] rearIndex;
    int[] next;
    int free;
    int n;
    int k; // k queues


    NQueues(int n, int k) {
        this.n = n;
        this.k = k;

        arr = new int[n];
        frontIndex = new int[k];
        rearIndex = new int[k];
        next = new int[n];

        for(int i=0; i<k; i++)
        {
            frontIndex[i] = -1;
        }

        for(int i=0; i<n-1; i++)
        {
            next[i] = i + 1;
        }
        next[n-1] = -1;

        free = 0;

    }

    void enqueue(int queueNo, int item) {
        if(free == -1) {
            System.out.println("queue overflow!");
        }

        int i = free;
        free = next[i];

        // if first time
        if(frontIndex[queueNo] == -1) {
            frontIndex[queueNo] = i;
        } else {
            next[rearIndex[queueNo]] = i;
        }

        arr[i] = item;

        next[i] = -1;

        rearIndex[queueNo] = i;


    }

    int deque(int queueNo) {
        if(frontIndex[queueNo] == -1) {
            System.out.println("queue underflow!");
        }

        int i = frontIndex[queueNo];
        frontIndex[queueNo] = next[i];

        next[i] = free;
        free = i;


        return arr[i];

    }
}
