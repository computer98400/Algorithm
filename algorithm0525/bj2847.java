package Algorithm.algorithm0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] test = new int[5];

        for(int i=0; i< test.length; i++){
            test[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        while(true){

            if(test[0] == 1 &&test[1] == 2 &&test[2] == 3 &&test[3] == 4 &&test[4] == 5){
                // for(int i =0; i< test.length; i++){
                //     sb.append(test[i]).append(' ');
                // }
                // sb.append('\n');
                break;
            }
            if(test[0] > test[1]){
                int temp = test[0];
                test[0] = test[1];
                test[1] = temp;
                
                for(int i =0; i< test.length; i++){
                    sb.append(test[i]).append(' ');
                }
                sb.append('\n');
                continue;
            }
            
            if(test[1] > test[2]){
                int temp = test[1];
                test[1] = test[2];
                test[2] = temp;
                for(int i =0; i< test.length; i++){
                    sb.append(test[i]).append(' ');
                }
                sb.append('\n');
                continue;    
            }
            
            if(test[2] > test[3]){
                int temp = test[2];
                test[2] = test[3];
                test[3] = temp;
                for(int i =0; i< test.length; i++){
                    sb.append(test[i]).append(' ');
                }
                sb.append('\n');
                continue;    
            }
            
            if(test[3] > test[4]){
                int temp = test[3];
                test[3] = test[4];
                test[4] = temp;
                for(int i =0; i< test.length; i++){
                    sb.append(test[i]).append(' ');
                }
                sb.append('\n');
                continue;    
            }
            
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
