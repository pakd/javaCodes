import java.util.HashMap;
import java.util.Map;

public class HashMapCollection {

    HashMapCollection() {

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        // putting values in map
        map.put(4, "four");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(5, "five");

        // iterator
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // check if key present or not

        boolean is5Present = map.containsKey(5);
        boolean is6Present = map.containsKey(6);

        System.out.println("Is 5 present : " + is5Present);
        System.out.println("Is 6 present : " + is6Present);

        // getting value for specific key
        System.out.println("value for key 3 : " + map.get(3));

    }
}
