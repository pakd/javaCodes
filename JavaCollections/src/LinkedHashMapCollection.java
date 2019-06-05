import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkedHashMapCollection {

    LinkedHashMapCollection() {

        Map<Integer, String> map = new LinkedHashMap<Integer, String>();

        // putting values in map
        map.put(4, "four");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(5, "five");

        // iterator
        for(Integer entry : map.keySet()) {
            System.out.println(entry + " : " + map.get(entry));
        }
    }
}
