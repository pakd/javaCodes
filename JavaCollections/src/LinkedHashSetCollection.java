import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetCollection {
    LinkedHashSetCollection() {
        Set<String> set = new LinkedHashSet<String>();

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
