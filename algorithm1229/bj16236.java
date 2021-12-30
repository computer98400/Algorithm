package algorithm1229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj16236 {

    public static int[][] map;
    public static boolean[][] visited;
    public static int startY;
    public static int startX;
    public static int[] dirY = {-1,1,0,0};
    public static int[] dirX = {0,0,-1,1};
    public static int solution = 0;
    public static int sharkSize = 2;
    public static int sharkCount = 0;
    public static int N;

    static class shark{
        int Y;
        int X;
        int time;

        shark(int y,int x, int time){
            this.Y = y;
            this.X = x;
            this.time = time;
        }
    }


    public static void bfs(){
        while(true){
            PriorityQueue<shark> que = new PriorityQueue<shark>(new Comparator<shark>() {

                @Override
                public int compare(shark o1, shark o2) {
                    if(o1.time == o2.time){
                        if(o1.Y == o2.Y){
                            return o1.X - o2.X;
                        }
                        return o1.Y - o2.Y;
                    }
                    return o1.time- o2.time;
                }
            }); 
            
            que.offer(new shark(startY, startX, 0));
            visited[startY][startX] = true;
            
            boolean eat = false;

            while(!que.isEmpty()){

                shark pos = que.poll();
                
                if(map[pos.Y][pos.X] != 0 && map[pos.Y][pos.X] < sharkSize){
                    eat(pos.time);
                    map[pos.Y][pos.X]=0;
                    startY = pos.Y;
                    startX = pos.X;
                    eat = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int tempY = pos.Y + dirY[i];
                    int tempX = pos.X + dirX[i];
                    if(tempY >=0 && tempY < map.length && tempX >=0 && tempX < map.length && !visited[tempY][tempX] && map[tempY][tempX] <= sharkSize){
                        que.offer(new shark(tempY, tempX, pos.time+1));
                        visited[tempY][tempX] = true;
                    }
                }
            }
            if(!eat){
                break;
            }
            que.clear();
        }
    }

    public static void eat(int time){

        solution += time;
        sharkCount++;

        if(sharkCount == sharkSize){
            sharkSize++;
      //      System.out.println("grow! : "+sharkSize);
            sharkCount = 0;
        }
        visited = new boolean[N][N];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    startY = i;
                    startX = j;
                    map[i][j] = 0;
                }
            }
        }

      //  for (int j = 0; j < N; j++) {
      //      System.out.println(Arrays.toString(map[j]));
      //  }

        bfs();
     //   System.out.println("shark pos : "+startY +" "+startX);
        System.out.println(solution);
    }
}
