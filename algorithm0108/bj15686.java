package algorithm0108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15686 {
    public static int M;
    public static ArrayList<int[]> houses;
    public static ArrayList<int[]> chickens;
    public static int solution = Integer.MAX_VALUE;
    
    public static void combi(int idx, int count,int[] checking) {
        if (count == M) {
            solution = Math.min(chickenSt(checking),solution);
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            checking[count] = i;
            combi(i + 1, count + 1, checking);
        }
    }
    
    
    public static int chickenSt(int[] list) {
        int[] temp = new int[houses.size()];
        Arrays.fill(temp, Integer.MAX_VALUE);
        for (int i = 0; i < houses.size(); i++) {
            for (int j = 0; j < list.length; j++) {
                temp[i] = Math.min(Math.abs(houses.get(i)[0] - chickens.get(list[j])[0])+Math.abs(houses.get(i)[1] - chickens.get(list[j])[1]), temp[i]);
            }
        }
        int test = 0;
        for (int i = 0; i < temp.length; i++) {
            test += temp[i];
        }
        return test;
    }
    



    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new int[] { i, j });
                } else if (map[i][j] == 2) {
                    chickens.add(new int[] { i, j });
                }
            }
        }
        //System.out.println(chickens.size()+" "+ M);
        combi(0, 0, new int[M]);
        System.out.println(solution);
    }
}
