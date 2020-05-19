import java.util.ArrayList;

public class NextPermutation {

    public void findNextPermutation(ArrayList<Integer> list) {

        // Step 1: Find the largest index k, such that list[k]<list[k+1]. If not exist, this is the last permutation.
        // (in this case    problem just sort the vector and return.)
        int n = list.size();
        int k = -1;

        for(int i = 0; i < n-1; i++){
            if(list.get(i) < list.get(i+1))
                k = i;
        }

        if(k == -1){
            System.out.println("No next sequence possible");
            printList(list);
            return;
        }

        // step 2 : Find the largest index l, such that list[l]>list[k] in list[k+1....end].
        int l = 0;
        for(int i = k+1; i < n; i++){
            if(list.get(i) > list.get(k)){
                l = i;
            }
        }

        // Step 3: Swap list[k] and list[l].
        int temp = list.get(k);
        list.set(k, list.get(l));
        list.set(l, temp);

        // Step 4 : reverse order k+1 to n-1
        int j = k + 1;
        int last = n-1;
        while(j <= last){
            temp = list.get(j);
            list.set(j, list.get(last));
            list.set(last, temp);
            j++;
            last--;
        }

        printList(list);
    }

    private void printList(ArrayList<Integer> list) {
        for(Integer x : list) {
            System.out.print(x + ", ");
        }
    }

    public void testFindNextPermutation() {
        int[] arr = {6,2,1,5,4,3,0};
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
        }
        findNextPermutation(list);
    }
}
