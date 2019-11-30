import java.util.Stack;

public class DecodeAString {

    public String decode(String input) {

        String ret = "";
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();

        for(int i=0; i<input.length(); i++) {
            // if it is a number
            char t = input.charAt(i);
            if(t >='0' && t <= '9') {
                intStack.push(t - '0');
            } else if(t == '[') {
                charStack.push(t);
            } else if(t == ']') {
                String temp = "";
                while(charStack.peek() != '[') {
                    temp += charStack.pop();
                }
                charStack.pop();
                int count = intStack.pop();

                for(int k=0; k<count; k++) {
                    for(int j=temp.length()-1; j>=0; j--) {
                        charStack.push(temp.charAt(j));
                    }
                }


            } else {
                charStack.push(t);
            }


        }

        while(charStack.isEmpty() == false) {
            ret = charStack.pop() + ret;
        }

        return ret;
    }

    public void test() {
        String str = "3[b2[ca]]";
        System.out.println(decode(str));
    }
}
