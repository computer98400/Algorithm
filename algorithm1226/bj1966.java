package Algorithm.algorithm1226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1966 {
    public static void main(String[] args) throws NumberFormatException, IOException {
       // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < Tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int check = Integer.parseInt(st.nextToken());
 //   System.out.println("test : "+N+" "+check);
            ArrayList<int[]> test = new ArrayList<>();
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                
                int show = Integer.parseInt(st.nextToken());
                if(j == check){
                  //  System.out.println("check!! : j : "+j +"show : "+ show);
                    test.add(new int[]{show,1});
                }else{
                  //  System.out.println("j : "+j +"show : "+ show);
                    test.add(new int[]{show,0});
                }
            }
            // for (int j = 0; j < test.size(); j++) {
            //     System.out.println(Arrays.toString(test.get(j)));
                
            // }
            int count = 0;
            while(true){
                boolean flag = true;
                int[] temp  = test.remove(0);
                for (int j = 0; j < test.size(); j++) {
                    if(temp[0] < test.get(j)[0]){
                        flag = false;
                        break;
                    }
                }
                
                if(!flag){
                    test.add(temp);
                    continue;
                }
                count++;
                if(flag && temp[1] == 1){
                    System.out.println(count);
                    break;
                }
            }




        }
        


    }
}
