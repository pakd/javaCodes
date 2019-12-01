import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    Queue<Node> queue;
    public int R;
    public int C;

    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isDelim(Node node) {
        if(node.x == -1 && node.y == -1) {
            return true;
        }
        return false;
    }

    public boolean isValid(int x, int y) {
        if(x>=0 && y>=0 && x<R && y<C) {
            return true;
        }
        return false;
    }

    public boolean checkAll(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(arr[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int find(int[][] arr) {

        queue = new LinkedList<>();

        // insert push rotten oranges into queue
        int r = arr.length;
        int c = arr[0].length;

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(arr[i][j] == 2) {
                    queue.add(new Node(i,j));
                }
            }
        }

        // push delimiter
        queue.add(new Node(-1, -1));


        // no of time frames
        int ans = 0;

        while(queue.isEmpty() == false) {

            // for maintaining no of time frames
            boolean flag = false;

            while( !isDelim(queue.peek())) {
                Node temp = queue.remove();


                // right cell
                if(isValid(temp.x+1, temp.y) && arr[temp.x + 1][temp.y] ==1) {
                    if(flag == false) {
                        flag  = true;
                        ans++;
                    }

                    arr[temp.x + 1][temp.y] = 2;

                    queue.add(new Node(temp.x + 1, temp.y));
                }

                // left cell
                if(isValid(temp.x-1, temp.y) && arr[temp.x - 1][temp.y] ==1) {
                    if(flag == false) {
                        flag  = true;
                        ans++;
                    }

                    arr[temp.x - 1][temp.y] = 2;

                    queue.add(new Node(temp.x - 1, temp.y));
                }

                // top cell
                if(isValid(temp.x, temp.y +1) && arr[temp.x ][temp.y + 1] ==1) {
                    if(flag == false) {
                        flag  = true;
                        ans++;
                    }

                    arr[temp.x ][temp.y + 1] = 2;

                    queue.add(new Node(temp.x , temp.y + 1));
                }

                // bottom cell
                if(isValid(temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] ==1) {
                    if(flag == false) {
                        flag  = true;
                        ans++;
                    }

                    arr[temp.x][temp.y - 1] = 2;

                    queue.add(new Node(temp.x, temp.y - 1));
                }


            }

            // removing delimiter
            queue.remove();

            if(!queue.isEmpty()) {
                queue.add(new Node(-1, -1));
            }

        }

        return (checkAll(arr)? -1:ans);



    }

    public void test() {
        R = 3;
        C = 5;
        int[][] arr = { {2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}};

        int ans = find(arr);
        if(ans == -1 ) {
            System.out.println("All oranges cannot rot");
        } else {
            System.out.println("No of time frames: " + ans);
        }
    }
}
