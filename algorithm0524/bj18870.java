package Algorithm.algorithm0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj18870 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        ArrayList<int[]> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i< N; i++){
            numbers.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        numbers.sort( new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]){
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(Integer.MAX_VALUE);
        int temp = Integer.MAX_VALUE;
        int count = -1;
        int[] answer = new int[N];
        for(int i =numbers.size()-1; i > -1; i--){
            if(temp != numbers.get(i)[1]){
                count++;
            }
            answer[numbers.get(i)[0]] = count;
            temp = numbers.get(i)[1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0; i< answer.length; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
