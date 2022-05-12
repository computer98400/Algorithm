package algorithm0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import permuNcombi.permu;

public class bj14713 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        ArrayList<Queue<String>> test = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Queue<String> temp = new LinkedList<>();
            while (st.hasMoreTokens()) {
                temp.offer(st.nextToken());
            }
            test.add(temp);
        }



        String[] answer = br.readLine().split(" ");
        int count = 0;
        boolean possible = true;
        while (count < answer.length) {
            boolean flag = false;
            // System.out.println("현재 값 : " + answer[count]);

            for (int i = 0; i < test.size(); i++) {
                // System.out.println("비교값 : " + test.get(i).peek());
                if (test.get(i).isEmpty()) {
                    continue;
                } else {
                    if (test.get(i).peek().equals(answer[count])) {
                        test.get(i).poll();
                        flag = true;
                        break;
                    }
                }
            }

            
            
            if (!flag) {
                possible = false;
                break;
            }
            count++;
        }
        for (int i = 0; i < test.size(); i++) {
            if (test.get(i).isEmpty()) {
                continue;
            } else {
                possible = false;
            }
        }
        
        if (possible) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
        


    }
}
