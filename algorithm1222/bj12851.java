package algorithm1222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj12851 {

    public static int[][] map;
    public static int[] dir = {-1, 1, 2};

    public static void bfs(int x, int K) {

        Queue<Integer> temp = new LinkedList<>();
        temp.offer(x);
        map[x][0] = 1;
        map[x][1] = 1;
        while (!temp.isEmpty()) {

            int pos = temp.poll();

            if (pos == K) {
                //System.out.println("끝");
                return;
            }

            for (int i = 0; i < 3; i++) {
                int tempX;

                if (i == 2) {
                    tempX = pos * dir[i];
                 //   System.out.println("check *2 : " + tempX);
                } else {
                    tempX = pos + dir[i];
                }
                
                
                if (tempX > 100000 || tempX < 0) {
                
                    continue;
                
                } else {
                    //가지치기
                    if (map[tempX][0] == 0) {
                        
                        temp.offer(tempX);
                    
                    } else {

                        if (map[pos][0] + 1 <= map[tempX][0]) {
                            temp.offer(tempX);
                        } else {
                            
                            continue;
                        
                        }
                    }
                }

                if (map[tempX][0] != 0) {

                    if (map[tempX][0] > map[pos][0] + 1) {

                        map[tempX][1] = 1;

                    } else if (map[tempX][0] == map[pos][0] + 1) {

                        map[tempX][1]++;

                    }

                } else {

                    map[tempX][0] = map[pos][0] + 1;
                    map[tempX][1]++;

                }
            }
        }
    }
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        map = new int[100001][2];


        bfs(N,K);
        System.out.println((map[K][0]-1)+"\n"+(map[K][1]));
    }
}
