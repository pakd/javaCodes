public class Nstacks {

    int[] arr;
    int[] next;
    int[] top;
    int free;
    int n;
    int k;

    Nstacks(int n, int k) {
        this.n = n;
        this.k = k;

        arr = new int[n];
        top = new int[k];
        next = new int[n];

        for(int i=0; i<k; i++)
        {
            top[i] = -1;
        }

        for(int i=0; i<n-1; i++)
        {
            next[i] = i + 1;
        }
        next[n-1] = -1;

        free = 0;

    }

    public void push(int stackNo, int elem) {
        if(free == -1) {
            System.out.println("stack overflow!");
            return;
        }

        int i = free;
        free = next[i];

        arr[i] = elem;

        next[i] = top[stackNo];
        top[stackNo] = i;

    }

    public int pop(int stackNo) {
        if(top[stackNo] == -1) {
            System.out.println("stack underflow");
            return Integer.MAX_VALUE;
        }

        int i = top[stackNo];
        top[stackNo] = next[i];

        next[i] = free;
        free = i;

        return arr[i];
    }

}
