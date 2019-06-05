import java.util.HashSet;
import java.util.Set;

public class HashSetCollection {

    HashSetCollection() {
        Set<String> set = new HashSet<String>();

        set.add("dog");
        set.add("cat");
        set.add("tiger");
        set.add("lion");
        set.add("monkey");

        for (String key : set)
        {
            System.out.println(key);
        }
        System.out.println();

        set.remove("cat");

        for (String key : set)
        {
            System.out.println(key);
        }

    }

}
