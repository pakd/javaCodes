public class MergeSort {


    public void mergesort(int[] arr, int l, int r) {

        if(l >= r) {
            return;
        }
        int mid = (l+r)/2;
        mergesort(arr, l, mid);
        mergesort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int m, int r) {

        int n1 = m + 1 - l;
        int n2 = r - m;
        int[] l_arr = new int[n1];
        int[] r_arr = new int[n2];

        for(int i=0;i<n1;i++) {
            l_arr[i]=arr[l+i];
        }
        for(int j=0;j<n2;j++) {
            r_arr[j]=arr[j + m + 1];
        }

        int i = 0, j = 0, k = l;

        while(i<n1 && j<n2)
        {
            if(l_arr[i]<r_arr[j])
            {
                arr[k++]=l_arr[i++];
            }
            else
            {
                arr[k++]=r_arr[j++];
            }
        }
        while(i<n1)
        {
            arr[k++]=l_arr[i++];
        }
        while(j<n2)
        {
            arr[k++]=r_arr[j++];
        }
    }


    public void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void test() {
        int[] arr = {10,5,2,4,-1};
        mergesort(arr, 0, arr.length-1);
        printArr(arr);

    }



}
