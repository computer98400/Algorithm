package algorithm0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj17140 {
    public static int[][] map;
    
    public static int sY = 0;
    public static int sX = 0;
    public static int sNum = 0;

    static class node implements Comparable<node> {
        int number;
        int count;

        node(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(node o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count == o.count) {
                return this.number - o.number;
            } else {
                return -1;
            }
        }

        

        @Override
        public String toString() {
            return this.number + " " + this.count;
        }

    }
    

    public static int sort(char dir, int idx) {
        int[] count = new int[101];

        ArrayList<node> test = new ArrayList<>();

        if (dir == 'R') {
            for (int i = 0; i < map.length; i++) {
                count[map[idx][i]]++;
            }
        } else {
            for (int i = 0; i < map.length; i++) {
                count[map[i][idx]]++;
            }
        }
        // System.out.println("dir : " + dir + " idx : " + idx + Arrays.toString(count));
        
        for (int i = 1; i < count.length; i++) {
            if (count[i] != 0) {
                test.add(new node(i, count[i]));
            }
        }
        test.sort(null);
        // System.out.println(test.toString());

        int[] result = new int[200];
        for (int i = 0; i < test.size(); i++) {
            result[i * 2] = test.get(i).number;
            result[i * 2 + 1] = test.get(i).count;
        }
        
        int returnidx = 0;

        if (dir == 'R') {
            for (int i = 0; i < map.length; i++) {
                if (result[i] == 0 && returnidx == 0) {
                    returnidx = i;
                }
                map[idx][i] = result[i]; 
            }
        } else {
            for (int i = 0; i < map.length; i++) {
                if (result[i] == 0 && returnidx == 0) {
                    returnidx = i;
                    break;
                }
                map[i][idx] = result[i]; 
            }
        }
        // System.out.println("returnidx :"+returnidx);

        return returnidx;

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        sY = Integer.parseInt(st.nextToken());
        sX = Integer.parseInt(st.nextToken());
        sNum = Integer.parseInt(st.nextToken());
        map = new int[100][100];

        for (int i = 0; i < 3; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ridx = 3;
        int cidx = 3;

        int solution = 0;

        while (solution < 100) {

            if (map[sY - 1][sX - 1] == sNum) {
                break;
            }
            int tempR = 0;
            int tempC = 0;
            if (ridx >= cidx) {
                for (int i = 0; i < ridx; i++) {
                    tempR = Math.max(sort('R', i), tempR);
                }
                cidx = tempR;
            } else {
                for (int i = 0; i < cidx; i++) {
                    tempC = Math.max(sort('C', i), tempC);
                }
                ridx = tempC;
            }
            // System.out.println(ridx + " " + cidx);
            solution++;
            System.out.println("=========================");
            for (int i = 0; i < ridx; i++) {
                for (int j = 0; j < cidx; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

        }
        System.out.println(solution);
    }
}
