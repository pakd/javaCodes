import java.util.Set;
import java.util.TreeSet;

public class TreeSetCollection {
    TreeSetCollection() {
        Set<String> set = new TreeSet<String>();

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
