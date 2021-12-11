package Algorithm.algorithm1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//넘어간 사실과 넘어가기전, 넘어간 후 상태를 정해주면 된다.
public class bj2206_notSolved {
    public static boolean[][] visited;
    public static boolean[][] copyVisited;
    public static int[][] copyMap;
    public static int[][] map;
    public static int[] dirX = {0,0,-1,1}; 
    public static int[] dirY = {1,-1,0,0}; 
    public static ArrayList<int[]> walls;
    public static int count;
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        count = Integer.MAX_VALUE;
        map = new int[N][M];
        copyMap = new int[N][M];
        visited = new boolean[N][M];
        copyVisited = new boolean[N][M];
        walls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                if(temp.charAt(j) ==  '1'){
                    walls.add(new int[]{i,j});
                    visited[i][j] = true;
                    copyVisited[i][j] = true;
                    map[i][j] = 999;
                    copyMap[i][j] = 999;
                }
            }
        }
        for (int i = 0; i < walls.size(); i++) {
            int[] broken = walls.get(i);    //각
            bfs(broken[0],broken[1]);
            for (int j = 0; j < map.length; j++) {
                for (int j2 = 0; j2 < map[0].length; j2++) {
                    map[j][j2] = copyMap[j][j2];
                    visited[j][j2] =  copyVisited[j][j2];
                }
            }
        }
        if(count == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
           System.out.println(count);
        }

    }
    static void bfs(int y, int x){
        map[y][x] = 0;
        visited[y][x] = false;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});        
        visited[0][0] = true;
        //벽을 부순다라는 개념이 모든 경우에서 부서지는게 아니라, 해당 값만 부서지는것이다.
        
        // -> 0,0 0,1(벽, 이부분에서 상태가 변함.) 0,2
        
        // -> 0,0 1,0(벽이 아니라서 그냥 유지됨.) 2,0
        
        // map에 정보를 담음
        
        // 맵을 건드리지 않고 bfs를 돌리는 방식을 생각한다. -> 클래스형식으로 만드는게 좋을듯함.
        
        // 맵을 중간에 바꾸는경우는 플레문제임 아 ㅋㅋ

        // visited의 경우는 공통 부분임.
        
        // visited는 업데이트가 되는 배열임.

        // 

        map[0][0] = 1;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for (int i = 0; i < dirX.length; i++) {
                int tempY = pos[0] + dirY[i];
                int tempX = pos[1] + dirX[i];
                if(tempY >=0 && tempX >=0 && tempY < map.length && tempX < map[0].length && !visited[tempY][tempX] && map[tempY][tempX] == 0){
                    queue.offer(new int[]{tempY, tempX});
                    visited[tempY][tempX] = true;
                    map[tempY][tempX] = map[pos[0]][pos[1]]+ 1;
                }
            }
        }
        // System.out.println("count : "+count);
        //  System.out.println("==============================================");
        // for (int i = 0; i < map.length; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        map[y][x] = 999;
        visited[y][x] = true;
        if(map[map.length-1][map[0].length-1] != 0){
            count = Math.min(count, map[map.length-1][map[0].length-1]);
        }
    }
}

