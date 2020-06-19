import java.util.*;

public class SubstringOfSizeKWithKDistinctCharacters {

    public void findSubstrings(String s, int k) {

        int len = s.length();

        int i = 0;

        Map<Character, Integer> map = new HashMap<>();
        Set<String> set = new LinkedHashSet<>();


        for(;i<k; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(;i<len; i++) {
            if(map.size() == k) {
                set.add(s.substring(i-k, i));
            }

            // remove older char
            int temp = map.get(s.charAt(i-k));
            map.put(s.charAt(i-k), temp-1);
            if(map.get(s.charAt(i-k)) == 0) {
                map.remove(s.charAt(i-k));
            }

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);

        }

        if(map.size() == k) {
            set.add(s.substring(i-k, i));
        }

        ArrayList<String> list = new ArrayList<>(set);

        for(String x : list) {
            System.out.print(x + " ");
        }
        System.out.println();
    }




    SubstringOfSizeKWithKDistinctCharacters() {


        // Output: ["abc", "bca", "cab"]
        String s1 = "abcabc";
        int k = 3;
        findSubstrings(s1, k);


        // Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
        String s2  = "awaglknagawunagwkwagl";
        k = 4;
        findSubstrings(s2, k);

        //Output: ["bac", "cab"]
        String s3 = "abacab";
        k = 3;
        findSubstrings(s3, k);
    }
}
