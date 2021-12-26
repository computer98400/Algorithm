package Algorithm.algorithm1226;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj13567 {
    public static int dir;
    public static int[] pos;
    public static int[][] map;

    public static void move(int N){
        if(dir == 0){
            pos[1] += N;
        }else if(dir == 1){
            pos[0] -= N;
        }else if(dir == 2){
            pos[1] -= N;
        }else {
            pos[0] += N;
        }
        
    }
    public static boolean check(){
        if(pos[0] < 0 || pos[0] >= map.length || pos[1] < 0 || pos[1] >= map[0].length ){
            return false;   
        }
        return true;
    }

    public static void turn(int N){
        if(N == 1){
            dir = (dir+1)%4;
        }else{
            if(dir == 0){
                dir = 3;
            }else{
                dir--;
            }
        }
    }

    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        
        StringTokenizer st =new StringTokenizer(sc.nextLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new int[M][M];
        pos = new int[2];
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            st =new StringTokenizer(sc.nextLine()," ");
            
            String temp1 = st.nextToken();
            int temp2 = Integer.parseInt(st.nextToken());

            if(temp1.equals("MOVE")){
                move(temp2);
            }else{
                turn(temp2);
            }

            if(check() == false){
                flag = false;
            }

        }
        if(!flag){
            System.out.println(-1);
        }else{
            System.out.println(pos[1]+" "+pos[0]);
        }

    }
}
