package algorithm1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj1620 {
    static HashMap<Integer, String> test = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N + 1; i++) {
            test.put(i, br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String check = br.readLine();
            if (check.charAt(0)-'0' > 0 && check.charAt(0)-'0' < 10) {
                sb.append(test.get(Integer.parseInt(check))+"\n");
            } else {
            }
        }
        System.out.println(sb);


    }
    
    // static int search(String word) {
    //     for (int temp : test.keySet()) {
    //         if (word.equals(test.get(temp))) {
    //             return temp;
    //         }
    //     }
    //     return 0;
    // }



}
