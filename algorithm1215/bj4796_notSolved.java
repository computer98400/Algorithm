package algorithm1215;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj4796_notSolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 0;
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(sc.nextLine(), " ");
            tc++;
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) {
                break;
            }  
            int count = 0;
            int mod = 0;
            while (V >= P) {
                V -= P;
                count++;
            }
//            System.out.println(V);
            if (V > 0) {
                mod = L - V;
            }
            System.out.println("Case "+tc+": "+((count*L)+mod));
        }

        



    }
}
