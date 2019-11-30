import javax.lang.model.element.NestingKind;

public class Main {

    public static void main(String[] args) {



//        // test stack reverse using recursion
//        ReverseStackUsingRecursion reverseStackUsingRecursion = new ReverseStackUsingRecursion();
//        reverseStackUsingRecursion.test_stack_reversal();
//
//
//        // test sort stock using recursion
//        SortStackUsingRecursion sortStackUsingRecursion = new SortStackUsingRecursion();
//        sortStackUsingRecursion.test__sort_stack();
//
//        // test delete middle element from stack using recursion
//        DeleteMiddleElementRecursion deleteMiddleElementRecursion = new DeleteMiddleElementRecursion();
//        deleteMiddleElementRecursion.test();
//
//        // test no of next continuous greater element
//        NumberOfNGEsOnRight numberOfNGEsOnRight = new NumberOfNGEsOnRight();
//        numberOfNGEsOnRight.test();
//
//        // test next greater frequency element
//        NextGreaterFrequencyElement nextGreaterFrequencyElement = new NextGreaterFrequencyElement();
//        nextGreaterFrequencyElement.test();
//
//        // test n stacks in array
//        test_nstack();
//
//        // test decode a string based on some format
//        DecodeAString decodeAString = new DecodeAString();
//        decodeAString.test();

        LargestRectangularAreaInHistogram largestRectangularAreaInHistogram = new LargestRectangularAreaInHistogram();
        largestRectangularAreaInHistogram.test();

    }

    public static void test_nstack() {
        Nstacks ks = new Nstacks(10, 3);

        // Let us put some items in stack number 2
        ks.push(2, 15);
        ks.push(2, 45);

        // Let us put some items in stack number 1
        ks.push(1, 17);
        ks.push(1, 49);
        ks.push(1, 39);

        // Let us put some items in stack number 0
        ks.push(0, 11);
        ks.push(0, 9);
        ks.push(0, 7);

        System.out.println(ks.pop(2));
        System.out.println(ks.pop(1));
        System.out.println(ks.pop(0));
    }


}
