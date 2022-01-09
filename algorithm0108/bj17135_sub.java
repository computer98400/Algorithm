package algorithm0108;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj17135_sub {
    public static int[][] map;
    


    public static void turn() {
        for (int i = test.size() - 1; i >= 0; i--) {
            if (test.get(i)[0] + 1 == R) {
                enemys--;
                test.remove(i);
            } else {
                test.set(i, new int[] { test.get(i)[0] + 1, test.get(i)[1] });
            }
        }
    }
    
    
    public static void attack() {
        ArrayList<int[]> deleteT = new ArrayList<>();
        for (int i = 0; i < arrow.size(); i++) {
            for (int j = test.size()-1; j>= 0; j--) {
                if (Math.abs(R - test.get(j)[0]) + Math.abs(arrow.get(i)[1] - test.get(j)[1]) <= D) {
                    deleteT.add(test.get(j));
                    break;
                }
            }
        }

        for (int i = 0; i < deleteT.size(); i++) {
            for (int j = 0; j < test.size(); j++) {
                if (deleteT.get(i)[0] == test.get(j)[0] && deleteT.get(i)[1] == test.get(j)[1]) {
                    //System.out.println(j);
                    test.remove(j);
                    solution++;
                    enemys--;
                    break;
                }

            }
        }

        map = new int[R][C];

        turn();
    }

    public static int solution;
    public static int enemys;
    public static ArrayList<int[]> arrow;
    public static ArrayList<int[]> test;
    public static int D;
    public static int R;
    public static int C;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        

        R = sc.nextInt();
        C = sc.nextInt();
        D = sc.nextInt();

        map = new int[R][C];

        sc.nextLine();
        test = new ArrayList<>();
        arrow = new ArrayList<>();
        arrow.add(new int[] { R, 0 });
        arrow.add(new int[] { R, 2 });
        arrow.add(new int[] { R, 4 });
        for (int i = 0; i < map.length; i++) {

            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    test.add(new int[] { i, j });
                    enemys++;
                }
            }
        }
        while (enemys != 0) {
            attack();
        }
        System.out.println(solution);

    }
}
