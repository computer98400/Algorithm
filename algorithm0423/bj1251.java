package algorithm0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj1251 {
    
    public static int N;
    public static String temp;
    public static ArrayList<String> answer;
    public static void divide(int leng) {
        System.out.println(leng);
        

    }


    public static void combi(int count, int idx, int[] arr) {
        if (count == 2) {
            StringBuilder sb2 = new StringBuilder();
            
            StringBuilder sb = new StringBuilder();
            sb.append(temp.substring(0, arr[0]));
            sb2.append(sb.reverse().toString());
            sb = new StringBuilder();
            sb.append(temp.substring(arr[0], arr[1]));
            sb2.append(sb.reverse().toString());
            sb = new StringBuilder();
            sb.append(temp.substring(arr[1]));
            sb2.append(sb.reverse().toString());
            answer.add(sb2.toString());
            return;
        }

        for (int i = idx; i < N; i++) {
            arr[count] = i;
            combi(count + 1, i + 1, arr);
        }


    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        temp = br.readLine();
        N = temp.length();
        answer = new ArrayList<>();
        
        combi(0, 1, new int[2]);
        Collections.sort(answer);
        System.out.println(answer.get(0));
    }
}
