import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BoxStackingProblem {

    public class Box {
        int length;
        int width;
        int height;

        public Box(int length, int width, int height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }
    }


    public List<Box> list;

    public int maxStackHeight() {
        int n = list.size();

        List<Box> boxComb = new LinkedList<>();

        for(int i=0; i<n; i++) {
            Box temp = list.get(i);

            // lets keep length bigger
            boxComb.add(new Box(Math.max(temp.length, temp.width),
                    Math.min(temp.length, temp.width)
                    ,temp.height));
            boxComb.add(new Box(Math.max(temp.height, temp.width),
                    Math.min(temp.height, temp.width)
                    ,temp.length));
            boxComb.add(new Box(Math.max(temp.height, temp.length),
                    Math.min(temp.height, temp.length)
                    ,temp.width));

        }

        boxComb.sort(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return (o2.length*o2.width) - (o1.length*o1.width);
            }
        });

        int boxCombSize = boxComb.size();

        for(int i=0; i<boxCombSize; i++) {
            System.out.println(boxComb.get(i).length + "," +
                    boxComb.get(i).width + "," +
                    boxComb.get(i).height);
        }



        int[] msh = new int[boxCombSize];

        for(int i=0; i<boxCombSize; i++) {
            msh[i] = boxComb.get(i).height;
        }

        for(int i=1; i<boxCombSize; i++) {
            for(int j=0; j<i; j++) {
                if(boxComb.get(j).length > boxComb.get(i).length &&
                boxComb.get(j).width > boxComb.get(i).width) {
                    msh[i] = Math.max(msh[i], msh[j] + boxComb.get(i).height);
                }
            }
        }

        int maxHeight = 0;
        for(int i=0; i<boxCombSize; i++) {
            if(maxHeight < msh[i]) {
                maxHeight = msh[i];
            }
        }
        return maxHeight;
    }

    public void test() {
        list = new LinkedList<>();
        list.add(new Box(4,6,7));
        list.add(new Box(1, 2, 3));
        list.add(new Box(4,5, 6));
        list.add(new Box(10,12, 32));
        //maxStackHeight();
        System.out.println(maxStackHeight());
    }
}
