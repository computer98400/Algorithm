package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class queuetest {
    public static void main(String[] args) {
        
        Queue<Integer> test = new LinkedList<>();


        test.offer(1);
        test.offer(2);
        test.offer(3);
        test.offer(4);
        System.out.println(test.peek());

    }
}
