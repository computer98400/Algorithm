
package algorithm1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> test = new HashSet<>();
        for (int i = 0; i < N; i++) {
            test.add(br.readLine());
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> check = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            if (test.contains(temp)) {
                count++;
                check.add(temp);
            }
        }
        Collections.sort(check);
        System.out.println(check.size());
        for (int i = 0; i < check.size(); i++) {
            sb.append(check.get(i)+"\n");
        }
        System.out.println(sb);

    }
}