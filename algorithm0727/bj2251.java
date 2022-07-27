import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class bj2251 {
    public static boolean[][][] check;
    public static int bsize;
    public static int asize;
    public static ArrayList<Integer> testcheck;
    //어떤 상태를 저장해야하는가?
    //현재 각 물통에 들어간 값을 묶어서 확인.

    static class current{
        int a;
        int b;
        int c;

        public current(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void bfs(int a, int b, int c){
        Queue<current> que = new LinkedList<>();
        que.offer(new current(a,b,c));

        while(!que.isEmpty()){
            current pos = que.poll();
            if(check[pos.a][pos.b][pos.c]){
                continue;
            }

            check[pos.a][pos.b][pos.c] = true;
            if(pos.a == 0){
                testcheck.add(pos.c);
            }

            //a -> c
            if(pos.a + pos.c > c){
                que.add(new current(pos.a+pos.c-c,pos.b,c));
            }else{
                que.add(new current(0,pos.b,pos.a+pos.c));
            }
            //c -> a
            if(pos.a+pos.c > asize){
                que.add(new current(asize,pos.b,pos.a+pos.c-asize));
            }else{
                que.add(new current(pos.a+pos.c,pos.b,0));
            }

            //b -> c
            if(pos.b + pos.c > c){
                que.add(new current(pos.a,pos.b+pos.c-c,c));
            }else{
                que.add(new current(pos.a,0,pos.b+pos.c));
            }

            //c -> b\
            if(pos.b + pos.c > bsize){
                que.add(new current(pos.a,bsize,pos.b+pos.c-bsize));
            }else{
                que.add(new current(pos.a,pos.b+pos.c,0));
            }
            //a -> b
            if(pos.a + pos.b > bsize){
                que.add(new current(pos.a+pos.b-bsize,bsize,pos.c));
            }else{
                que.add(new current(0,pos.a+pos.b,pos.c));
            }
            //b -> a
            if(pos.a + pos.b > asize){
                que.add(new current(asize,pos.a+pos.b-asize,pos.c));
            }else{
                que.add(new current(pos.a+pos.b,0,pos.c));
            }
        }


    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        check = new boolean[201][201][201];
        String[] numbers = br.readLine().split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);
        asize = a;
        bsize = b;
        testcheck = new ArrayList<>();
        bfs(0,0,c);

        
        Collections.sort(testcheck);
		for (int i = 0; i < testcheck.size(); i++)
			System.out.print(testcheck.get(i) + " ");
    }

}
