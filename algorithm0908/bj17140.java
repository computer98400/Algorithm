package algorithm0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj17140 {
    public static int[][] map;
    public static int Ridx = 0;
    public static int Cidx = 0;


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
                if (this.number > o.count) {
                    return 1;
                }
                return 1;
            }
            return -1;
        }
        @Override
        public String toString() {
            return this.number+" "+this.count;
        }
    


    }

    public static int Csort(char dir, int idx) {
        int[] count = new int[101];
        ArrayList<node> test = new ArrayList<>();
        if (dir == 'R') {
            // System.out.println(Arrays.toString(map[idx]));
            for (int i = 0; i < map.length; i++) {
                count[map[idx][i]]++;
            }
            
        } else {
            for (int i = 0; i < map.length; i++) {
                count[map[i][idx]]++;
            }
        }
        // System.out.println("count : "+Arrays.toString(count));
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                
            } else {
                // System.out.println("test : "+i+" "+count[i]);
                test.add(new node(i, count[i]));
            }

        }
        // System.out.println("==========================================");
        test.sort(null);
        // System.out.println(test.toString());
        int[] result = new int[100];
        if (test.size() > 50) {
            for (int i = 0; i < 50; i++) {
                result[i*2] = test.get(i).number;
                result[i*2+1] = test.get(i).count;
            }
            
        } else {
            for (int i = 0; i < test.size(); i++) {
                result[i * 2] = test.get(i).number;
                result[i * 2 + 1] = test.get(i).count;
            }
        }

        int returnidx = 0;
        // System.out.println(Arrays.toString(result));
        if (dir == 'C') {
            for (int i = 0; i < map.length; i++) {
                if (result[i] == 0) {
                    returnidx = i;
                    break;
                }
                map[i][idx] = result[i];
            }
            
        } else {
            for (int i = 0; i < map.length; i++) {
                if (result[i] == 0) {
                    returnidx = i;
                    break;
                }
                map[idx][i] = result[i];
            }
        }
        System.out.println("return idx : "+returnidx);
        return returnidx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int posY = Integer.parseInt(st.nextToken());
        int posX = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        map = new int[100][100];

        for (int i = 0; i < 3; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // for (int i = 0; i < map.length; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        int checkRidx = 3;
        int checkCidx = 3;
        int solution = 0;
        while (map[posY - 1][posX - 1] != number) {
            System.out.println("start :" + checkRidx + " " + checkCidx);
            int tempR = 0;
            int tempC = 0;
            if (checkRidx >= checkCidx) {
                System.out.println("R check");
                for (int i = 0; i < 100; i++) {
                    if (map[i][0] == 0)
                        break;
                    tempR = Math.max(Csort('R', i), tempR);
                }
            } else {
                System.out.println("C check");
                for (int i = 0; i < 100; i++) {
                    if (map[0][i] == 0)
                        break;
                    tempC = Math.max(Csort('C', i), tempC);
                }
            }

            if (tempC == 0) {
                System.out.println("one cycle : "+tempR);
                checkRidx = tempR;
                continue;
            }
            
            if (tempR == 0) {
                checkCidx = tempC;
                continue;
            }

            System.out.println("end :" + checkRidx + " " + checkCidx);
            solution++;
        }
        // System.out.println(map[posY][posX]);
        System.out.println(solution);
            
    }
}
