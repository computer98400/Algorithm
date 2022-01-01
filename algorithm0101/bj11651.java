package algorithm0101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj11651 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> test = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            test.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
        }
 
        test.sort(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
            
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test.size(); i++) {
            sb.append(test.get(i)[0] + " " + test.get(i)[1] + "\n");
        }
        
        System.out.println(sb);
    }
}
