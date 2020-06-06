import java.util.*;

public class KMostFrequentWordsInAReview {


    KMostFrequentWordsInAReview() {
        int k1 = 2;
        String[] keywords1 = {"anacell", "cetracular", "betacellular"};
        String[] reviews1 = {
        "Anacell provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell"};
        List<String> l1 = solve(k1, keywords1, reviews1);
        printList(l1);



        int k2 = 2;
        String[] keywords2 = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[]  reviews2 = {
        "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular"};
        List<String> l2 = solve(k2, keywords2, reviews2);
        printList(l2);
    }


    private static List<String> solve(int k, String[] keywords, String[] reviews) {

        // creating set of keywords

        Set<String> dict = new HashSet<>();
            //dict.addAll(Arrays.asList(keywords));
        for(String x : keywords) {
            dict.add(x.toLowerCase());
        }

        // final string to be returned
        List<String> ans = new ArrayList<>();

        // HashMap for counting valid occurrences
        Map<String, Integer> map = new HashMap<>();


        for(String x : reviews) {
            Set<String> localSet = new HashSet<>();
            String[] arr = x.split(" ");

            for(String it : arr) {
                it = it.toLowerCase();

                if(!localSet.contains(it)) {

                    if(dict.contains(it)) {
                        map.put(it, map.getOrDefault(it, 0) + 1);
                        localSet.add(it);
                    }
                }
            }
        }

        // instead make arraylist
        List<String> temp = new ArrayList<>();
        System.out.println("debug");
        for(String x : map.keySet()) {
            temp.add(x);

            System.out.println(x + "->" + map.get(x));
        }


        temp.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int c = map.getOrDefault(o2, 0) - map.getOrDefault(o1, 0);
                if(c!=0) {
                    return  c;
                }
                return o1.compareTo(o2);
            }
        });

        int i=0;
        while(k-- > 0) {
            ans.add(temp.get(i));
            i++;
        }

        return ans;
    }

    public void printList(List<String> l) {
         for(String x : l) {
             System.out.print(x + " ");
         }
        System.out.println();
    }


}
