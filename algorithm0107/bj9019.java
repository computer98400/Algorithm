package algorithm0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9019 {

    public static boolean[] numbers = new boolean[10000];
    public static int D(int number) {
        return (2*number)%10000;
    }
    
    public static int S(int number) {
        if (number == 0) {
            return 9999;
        }
        return number-1;
    }
    
    public static int L(int number) {
        String temp = Integer.toString(number);
        if (temp.length() == 4) {
            String temp3 = temp.substring(1)+temp.charAt(0);
            return Integer.parseInt(temp3);
        } else {            
            return number*10;
        }
    }
    
    public static int R(int number) {
        String temp = Integer.toString(number);
        if(temp.length() == 1){
            temp = "000"+temp;
        }else if(temp.length() == 2){
            temp = "00"+temp;
        }else if(temp.length()== 3){
            temp="0"+temp;
        }
        String temp3 = temp.charAt(temp.length() - 1) + temp.substring(0, temp.length() - 1);
        return Integer.parseInt(temp3);
    }

    public static int A;
    public static int B;

    static class check { 
        int num;
        int count;
        String moving;

        check(int num, int count, String temp) {
            this.num = num;
            this.count = count;
            this.moving = temp;
        }

    }

    public static void bfs() {
        Queue<check> que = new LinkedList<>();
        numbers = new boolean[10000];
        que.offer(new check(A, 0, ""));
        numbers[A] = true;
        while (!que.isEmpty()) {
            check temp = que.poll();
            //System.out.println("check");
            if (temp.num == B) {
                
                //System.out.println("check22222222");
                System.out.println(temp.moving);
                return;

            }
            if (!numbers[D(temp.num)]) {
                que.offer(new check(D(temp.num), temp.count + 1, temp.moving + 'D'));
                numbers[D(temp.num)] = true;
            }

            if (!numbers[S(temp.num)]) {
                que.offer(new check(S(temp.num), temp.count + 1, temp.moving + 'S'));
                numbers[S(temp.num)] = true;
            }

            if (!numbers[L(temp.num)]) {
                que.offer(new check(L(temp.num), temp.count + 1, temp.moving + 'L'));
                numbers[L(temp.num)] = true;
            }

            if (!numbers[R(temp.num)]) {
                que.offer(new check(R(temp.num),temp.count+1,temp.moving+'R'));
                numbers[R(temp.num)] = true;
            }

        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int Tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < Tc; i++) {
            
            st = new StringTokenizer(br.readLine(), " ");
            
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bfs();
        }
    }

}
