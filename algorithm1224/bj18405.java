package Algorithm.algorithm1224;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj18405 {
    public static int[][] map ;
    public static boolean[][] visited;
    public static Queue<young> que;
    public static int[] dirY = {0,0,1,-1};
    public static int[] dirX = {1,-1,0,0};

    static class young{
        int N;
        int x;
        int y;
        int dep;
        young(int N, int y, int x){
            this.N = N;
            this.y = y;
            this.x = x;
        }
    }



    public static void bfs(){
        
        while(!que.isEmpty()){

            young pos = que.poll();

            for (int i = 0; i < dirX.length; i++) {
                int tempY = pos.y + dirY[i];
                int tempX = pos.x + dirX[i];

                if(tempY >= 0 && tempX >= 0 && tempY <map.length && tempX < map.length && map[tempY][tempX] == 0 && !visited[tempY][tempX]){
                    map[tempY][tempX] = pos.N;
                    visited[tempY][tempX] = true;
                }
            }


        }



    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        map = new int[N][N];
        visited = new boolean[N][N];
        que = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.N, o2.N));        
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(sc.nextLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    que.offer(new young(map[i][j],i,j));
                    visited[i][j] = true;
                }
            }
        }
        int S  = sc.nextInt();
        int solutionY  = sc.nextInt();
        int solutionX  = sc.nextInt();

        for (int i = 0; i < S; i++) {
            int temmp = 0;
            for (int j = 0; j < map.length; j++) {
                for (int j2 = 0; j2 < map.length; j2++) {
                    if(map[j][j2] != 0){
                        que.offer(new young(map[j][j2],j,j2));
                    }else{
                        temmp++;
                    }
                }
            }
            if(temmp == 0){
                break;
            }
            bfs();
            System.out.println("[================================");
            for (int k = 0; k < map.length; k++) {
                System.out.println(Arrays.toString(map[k]));
            }
        }

        System.out.println(map[solutionY-1][solutionX-1]);
    }


}