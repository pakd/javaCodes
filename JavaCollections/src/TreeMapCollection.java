import java.util.Map;
import java.util.TreeMap;

public class TreeMapCollection {

    // tree map stores keys in sorted order
    void TreeMapSample() {

        Map<Integer, String> map = new TreeMap<Integer, String>();


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
