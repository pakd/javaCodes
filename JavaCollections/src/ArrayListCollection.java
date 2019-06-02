import java.util.ArrayList;
import java.util.List;

public class ArrayListCollection {

    void ArrayListSample() {
        List<String> list = new ArrayList<String>();

        // can also write this
        /*ArrayList<String> list = new ArrayList<String>();*/

        // adding values to list in last
        list.add("dhoni");
        list.add("kohli");
        list.add("rohit");
        list.add("rahul");

        // iterator
        for(String values : list) {
            System.out.println(values);
        }

        // removing element
        list.remove(list.size()-1);

        for(String values : list) {
            System.out.println(values);
        }

        // adding value to any position
        list.add(1, "shikhar");
        list.add(0, "jadhav");

        System.out.println();
        for(String values : list) {
            System.out.println(values);
        }
    }
}
