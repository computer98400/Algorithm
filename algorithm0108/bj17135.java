package algorithm0108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj17135 {
    public static int[][] map;
    public static int N;
    public static int distance;
    public static ArrayList<int[]> enemies;
    
    public static void combi(int idx, int count, int[] numbers) {
        if (count == 3) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = idx; i < N; i++) {
            numbers[count] = i;
            combi(i+1, count+1, numbers);
        }
    }

    public static HashSet<Integer> kill = new HashSet<>();

    public static void fight(int[] arrows) {
        int size = enemies.size();
        for (int i = 0; i < arrows.length; i++) {
            for (int j = 0; j < enemies.size(); j++) {
                if (Math.abs(map[6][i] - enemies.get(j)[0]) + Math.abs(map[6][i] - enemies.get(j)[1]) <= distance) {
                    kill.add(j);
                }
            }
        }
        
    }

    public static void attack(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            enemies.remove(temp[i]);
        }
    }

    public static void turn() {
        for (int[] test : enemies) {
            test[0]++;
            if (test[0] == map.length) {
                enemies.remove(test);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        distance = Integer.parseInt(st.nextToken());

        map = new int[N+1][M];
        enemies = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    enemies.add(new int[] { i, j });
                }
            }
        }
        combi(0, 0, new int[3]);

    }
}
