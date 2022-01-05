package algorithm0105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17141 {


    public static int[][] map;
    public static boolean[][] visited;
    public static int[] numbers;
    public static ArrayList<int[]> walls;
    public static ArrayList<int[]> vi;
    public static int viCount;
    public static int N;
    public static int M;
    public static int[] dirY = {-1,1,0,0};
    public static int[] dirX = { 0, 0, -1, 1 };
    public static int zeroCount = 0;
    public static int solution = Integer.MAX_VALUE;
    public static void combi(int idx, int count) {
        if (count == M) {
            //System.out.println(Arrays.toString(numbers));
            solution = Math.min(solution,bfs());
           // System.out.println("check : "+solution);
            return;
        }

        for (int i = idx; i < viCount; i++) {
            numbers[count] = i;
            combi(i + 1, count + 1);
        }
    }
    
    static class mknode {
        int y;
        int x;
        int time;

        mknode(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }


    public static int bfs() {
        Queue<mknode> que = new LinkedList<>();
        visited = new boolean[N][N];
        map = new int[N][N];
       // System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < walls.size(); i++) {
            visited[walls.get(i)[0]][walls.get(i)[1]] = true;
            map[walls.get(i)[0]][walls.get(i)[1]] = 1;
        }
        for (int i = 0; i < numbers.length; i++) {
            que.offer(new mknode(vi.get(numbers[i])[0], vi.get(numbers[i])[1], 0));
            visited[vi.get(numbers[i])[0]][vi.get(numbers[i])[1]] = true;
        }
        int count = 0;
        int tempTime = 0;
        while (!que.isEmpty()) {
            mknode pos = que.poll();

            for (int i = 0; i < 4; i++) {
                int tempy = pos.y + dirY[i];
                int tempx = pos.x + dirX[i];

                if (tempy < 0 || tempy >= N || tempx < 0 || tempx >= N)
                    continue;
                if (map[tempy][tempx] == 1 || visited[tempy][tempx])
                    continue;

                que.offer(new mknode(tempy, tempx, pos.time + 1));
                visited[tempy][tempx] = true;
                count++;
                tempTime = Math.max(tempTime, pos.time + 1);
            }
            
        }
        //System.out.println("zero : " + zeroCount + " " + count);
        if (zeroCount == count) {
            //System.out.println("check1");
            return tempTime;
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        walls = new ArrayList<>();
        vi = new ArrayList<>();
        numbers = new int[M];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    walls.add(new int[] { i, j });
                    continue;
                }
                if (map[i][j] == 2) {
                    vi.add(new int[] { i, j });
                    viCount++;
                    continue;
                }
                zeroCount++;
            }
        }
        
        zeroCount = zeroCount + (vi.size() - M);

        combi(0, 0);
        if (solution == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(solution); 
        }
    
    }
}
