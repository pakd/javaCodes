import java.util.LinkedList;
import java.util.List;

public class LinkedListCollection {
    LinkedListCollection() {

        List<Integer> list = new LinkedList<Integer>();

        // can also write this
        /*LinkedList<String> list = new LinkedList<String>();*/

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // iterator
        for(Integer values : list) {
            System.out.println(values);
        }

        // removing element
        list.remove(list.size()-1);

        System.out.println();
        for(Integer values : list) {
            System.out.println(values);
        }

        // adding value to any position
        list.add(1, 7);
        list.add(0, 8);

        System.out.println();
        for(Integer values : list) {
            System.out.println(values);
        }

    }
}
