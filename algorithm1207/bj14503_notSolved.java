package Algorithm.algorithm1207;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj14503_notSolved {

    public static boolean[][] visited;
    public static int[][] map;
    public static int[] dirY = {-1,0,1,0};
    public static int[] dirX = {0,-1,0,1};
    public static int robotY;
    public static int robotX;
    public static int robotDir;
    public static int solution;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        map = new int[N][M];
        visited = new boolean[N][M];

        robotY = sc.nextInt();
        robotX = sc.nextInt();
        robotDir = sc.nextInt();
        sc.nextLine();
        StringTokenizer st;
        int temp = 0;
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(sc.nextLine()," ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    visited[i][j] = true;
                    temp++;
                }
            }
        }
        clean();

        System.out.println(solution-temp);


    }
     //1번
    static void clean(){
        visited[robotY][robotX] = true;
        solution++;
        search();
    }
    //움직임.
    static void move(){
        switch(robotDir){
            case 0:
            if(map[robotY-1][robotX] != 1 && robotY-1 >=0 && robotY-1 < map.length){
                System.out.println("move to : "+robotY+" "+robotX);
                robotY -= 1;
                clean();
            }
            return;
            case 1:
            if(map[robotY][robotX-1] != 1 && robotX-1 >=0 && robotX-1 < map[0].length){
                System.out.println("move to : "+robotY+" "+robotX);
                robotX-= 1;
                clean();
            }
            return;
            case 2:
            if(map[robotY+1][robotX] != 1 && robotY+1 >=0 && robotY+1 < map.length){
                System.out.println("move to : "+robotY+" "+robotX);
                robotY+= 1;
                clean();
            }
            return;
            case 3:
            if(map[robotY][robotX+1] != 1 && robotX+1 >=0 && robotX+1 < map[0].length){
                System.out.println("move to : "+robotY+" "+robotX);
                robotX+= 1;
                clean();
            }
            return;
        }
    }
   
    //돌기
    static void turn(){
        robotDir = (robotDir+1)%4;
        return;
    }
    static void stop(){
       System.out.println(solution);
    }
    static void back(){
        switch(robotDir){
            case 0:
                if(map[robotY+1][robotX] != 1 && robotY+1 >=0 && robotY+1 < map.length){
                    robotY+= 1;
                    search();
                }else{
                    stop();
                }
            return;
            case 1:
                if(map[robotY][robotX+1] != 1 && robotX+1 >=0 && robotX+1 < map[0].length){
                    robotX+= 1;
                    search();
                }else{
                    stop();
                }
            return;
            case 2:
                if(map[robotY-1][robotX] != 1 && robotY-1 >=0 && robotY-1 < map.length){
                    robotY -= 1;
                    search();
                }else{
                    stop();
                }
            return;
            case 3:
                if(map[robotY][robotX-1] != 1 && robotX-1 >=0 && robotX-1 < map[0].length){
                    robotX-= 1;
                    search();
                }else{
                    stop();
                }
            return;
        }
    }
    static void search(){
        boolean cc = false;
        for (int i = 0; i < dirX.length; i++) {
            turn();
            if(map[robotY+dirY[robotDir]][robotX+dirX[robotDir]] == 0 &&!visited[robotY+dirY[robotDir]][robotX+dirX[robotDir]]){
                cc = true;
                break;
            }
        }

        if(!cc){
            move();
            return;
        }else{
            back();
            return;
        }



        //c


        //d

    }

}
