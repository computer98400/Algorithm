package Algorithm.algorithm1224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj23757 {
    public static void main(String[] args) throws IOException {
      //  Scanner sc= new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] kids = new int[M];
        PriorityQueue<Integer> box = new PriorityQueue<>((o1,o2) -> Integer.compare(o2, o1));
        
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            box.offer(Integer.parseInt(st.nextToken()));
        }
        boolean flag = true;
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < kids.length; i++) {
            int check = box.poll();
            int temp = Integer.parseInt(st.nextToken());
            if(check - temp >= 0){
                check -= temp;
            }else{
                flag = false;
                break;
            }
            box.offer(check);
        }
        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
