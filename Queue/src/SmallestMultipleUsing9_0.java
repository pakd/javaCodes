import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestMultipleUsing9_0 {

    public int maxLimit = 1000;

    public Queue<String> queue;
    public List<String> list;

    public void generateNumbers() {
        queue.add("9");

        int i = 1;

        while(i <= maxLimit) {
            String temp = queue.remove();
            list.add(temp);
            i++;

            queue.add(temp + "0");
            queue.add(temp + "9");
        }
    }

    public int findsmallestMultiple(int n) {
        for(int i=0; i<list.size(); i++) {
            int temp = Integer.parseInt(list.get(i));
            if(temp % n == 0) {
                return temp;
            }
        }
        return -1;
    }

    public void test() {


        queue = new LinkedList<>();
        list = new LinkedList<>();
        generateNumbers();
        int n = 7;
        System.out.println(findsmallestMultiple(7)); //9009

    }
}
