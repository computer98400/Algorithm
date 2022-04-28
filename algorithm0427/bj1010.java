package algorithm0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1010 {

    public static long test(long i) {
        if (i == 1) {
            return 1;
        }
        return test(i - 1) * i;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long m = Integer.parseInt(br.readLine());
        long n = Integer.parseInt(br.readLine());
        
        System.out.println(test(n));
        System.out.println(test(n - m) * test(m));
        System.out.println(test(n - m));
        System.out.println(test(m));
    }
}
