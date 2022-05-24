package Algorithm.algorithm0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1292 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[1001];
        int count =1 ;
        int idx = 1;
        while(true){
            if(idx == 1000){
                break;
            }

            int temp = count;
            while(temp > 0){
                numbers[idx] = count;
                idx++;
                temp--;
                if(idx == 1000){
                    numbers[idx] = count;
                    break;
                }
            }
            count++;
        }
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int i= start;i<=end; i++){
            answer += numbers[i];
        }
        System.out.println(answer);
    }
}
