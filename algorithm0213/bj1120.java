package algorithm0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        String A = st.nextToken();
        String B = st.nextToken();


        if (A.length() == B.length()) {
            int count = 0;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    count++;
                }
            }
            System.out.println(count);
        } else {
            int solution = Integer.MAX_VALUE;
            for (int i = 0; i <= B.length() - A.length(); i++) {
                int count = 0;
                for (int j = i; j < i + A.length(); j++) {
                    if (A.charAt(j - i) != B.charAt(j)) {
                        count++;
                    }
                }
                // System.out.println(count);
                solution = Math.min(solution, count);
            }

                System.out.println(solution);

        }

    }
}
