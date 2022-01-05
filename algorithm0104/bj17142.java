package algorithm0104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17142 {

    public static int[][] map;
    public static boolean[][] visited;
    public static int M;
    public static int N;
    public static int[] numbers;
    public static ArrayList<int[]> vi;
    public static ArrayList<int[]> walls;
    public static int[] dirY = { -1, 1, 0, 0 };
    public static int[] dirX = { 0, 0, -1, 1 };
    public static int solution;

    static class mknode {
        int y;
        int x;
        int time;

        mknode(int y, int x, int time) { //생성자 contructor
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    public static void combi(int idx, int count, int[] test) {
        if (count == M) {
            solution = Math.min(solution, bfs(test));
            return;
        }

        for (int i = idx; i < numbers.length; i++) {
            test[count] = numbers[i];
            combi(i + 1, count + 1, test);
        }
    }

    public static int bfs(int[] positions) {
        Queue<mknode> que = new LinkedList<>();
        int temp = 0;
        int count = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < walls.size(); i++) {
            visited[walls.get(i)[0]][walls.get(i)[1]] = true;
        }

      //  StringBuilder sb = new StringBuilder();
        for (int i = 0; i < positions.length; i++) {
            que.offer(new mknode(vi.get(positions[i])[0], vi.get(positions[i])[1], 0));

            //System.out.println(Arrays.toString(vi.get(i)));

            visited[vi.get(positions[i])[0]][vi.get(positions[i])[1]] = true;

        }

        while (!que.isEmpty()) {
            mknode pos = que.poll();

            for (int i = 0; i < 4; i++) {
                int tempY = pos.y + dirY[i];
                int tempX = pos.x + dirX[i];

                if (tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map.length && !visited[tempY][tempX]
                        && (map[tempY][tempX] == 0 || map[tempY][tempX] == 2)) {
                    if (map[tempY][tempX] == 2) {
                        que.offer(new mknode(tempY, tempX,pos.time+1));
                        visited[tempY][tempX] = true;
                    } else {    
                        que.offer(new mknode(tempY, tempX, pos.time + 1));
                        //sb.append(" y: " + tempY + " x: " + tempX+" time : "+(pos.time+1)+"\n");
                        visited[tempY][tempX] = true;
                        temp = Math.max(temp, pos.time + 1);
                        count++;
                    }
                }
            }
        }
        if (count == zero) {
            return temp;
        } else {
//            System.out.println(count+" "+zero);
            return Integer.MAX_VALUE;
        }
    }

    public static int zero;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        solution = Integer.MAX_VALUE;
        zero = 0;
        vi = new ArrayList<>();
        walls = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                    walls.add(new int[] { i, j });
                    continue;
                }
                if (map[i][j] == 2) {
                    vi.add(new int[] { i, j });
                    continue;
                } else {
                    zero++;
                }
            }
        }

        numbers = new int[vi.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        combi(0, 0, new int[M]);

        if (solution == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(solution);
        }
    }
}
