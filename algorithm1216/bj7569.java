package algorithm1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7569 {
    public static int[][][] map;
    public static boolean[][][] visited;
    public static int[] dirX = {0,0,1,-1,0,0};
    public static int[] dirY = {1,-1,0,0,0,0};
    public static int[] dirH = { 0, 0, 0, 0, 1, -1 };
    static Queue<t> test = new LinkedList<>();

    static class t{
        int N;
        int M;
        int H;
        int count;

        t(int N, int M, int H,int count) {
            this.N = N;
            this.M = M;
            this.H = H;
            this.count = count;
        }
    }




    public static void bfs() {
        
        while(!test.isEmpty()){
            t Test = test.poll();

            for(int i=0 ;i<dirX.length;i++){
                int tempN = Test.N + dirY[i];
                int tempM = Test.M + dirX[i];
                int tempH = Test.H + dirH[i];
                
                if (tempN >= 0 && tempM >= 0 && tempH >= 0 && tempN < map.length && tempM < map[0].length
                        && tempH < map[0][0].length && !visited[tempN][tempM][tempH] && map[tempN][tempM][tempH] == 0) {
                    test.offer(new t(tempN, tempM, tempH, Test.count + 1));
                    map[tempN][tempM][tempH] = Test.count+1;
                    visited[tempN][tempM][tempH] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        map = new int[N][M][H];
        visited = new boolean[N][M][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j2 = 0; j2 < M; j2++) {
                    int temp = Integer.parseInt(st.nextToken());
                    map[j][j2][i] = temp;
                    if (temp == 1) {
                        test.offer(new t(j, j2, i, 0));
                        visited[j][j2][i] = true;
                    }
                    if(temp == -1){
                        visited[j][j2][i] = true;
                    }
                }
            }
        }
        bfs();
        int count = 0;
        first: for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                for (int j2 = 0; j2 < map[0][0].length; j2++) {
                    if (map[i][j][j2] == 0) {
                        count = -1;
                        break first;
                    }
                    count = Math.max(count, map[i][j][j2]);
                }
            }
        }
        if (count == 1) {
            System.out.println(0);
        }else {
            System.out.println(count);
        }

    }
}
