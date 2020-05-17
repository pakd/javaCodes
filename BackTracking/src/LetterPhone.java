import java.util.*;

public class LetterPhone {


    /*
    Input: Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    */

    public void generateLetterCombinations(String in) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        ArrayList<String> ans = new ArrayList<>();

        String current = "";
        int index = 0;

        generateLetterCombinationsUtil(in, current, ans, map, index);
        printList(ans);
    }


    public void generateLetterCombinationsUtil(String A, String curr, ArrayList<String> ans, Map<Integer, String> map, int index) {

        if(curr.length() == A.length()) {
            if(!ans.contains(curr)) {
                ans.add(curr);

            }
            return;
        }

        int val = A.charAt(index) - '0';
        String temp = map.get(val);

        for(int i=0; i<temp.length(); i++) {

            // choose
            curr += temp.charAt(i);

            // explore
            generateLetterCombinationsUtil(A, curr, ans, map, index+1);

            // un-choose
            curr = curr.substring(0, curr.length()-1);
        }
    }

    public void printList(ArrayList<String> list) {
        for(String c : list) {
            System.out.println(c + " ");
        }
    }


    public void testGenerateLetterCombinations() {
        String text = "23";
        generateLetterCombinations(text);

    }
}
