package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class mkClass {
    //내부클래스
    static class t{
        int N;
        int M;
        int H;

        t(int N, int M, int H) {
            this.N = N;
            this.M = M;
            this.H = H;
        }
    }

    public static void main(String[] args) {
        Queue<t> test = new LinkedList<>();
        
        test.offer(new t(1, 2, 3));
    }
}
