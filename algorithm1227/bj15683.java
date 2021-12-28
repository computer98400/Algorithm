package Algorithm.algorithm1227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj15683 {
    

    static class cctv{
        int y;
        int x;
        int number;

        cctv(int y, int x, int dir){
            this.y = y;
            this.x = x;
            this.number = dir;
        }
    }

    public static int[][] map;
    public static boolean[][] visited;
    public static ArrayList<cctv> test;

    public static void search(cctv temp){
            int count = 0;
            int[] checklist = new int[4];
            // 오른쪽
            for (int j = temp.x; j < map[0].length; j++) {
                if(j== map[0].length-1){
                    checklist[0] = count;
                    break;
                }else if( map[temp.y][j] == 6){
                    checklist[0] = count-1;
                    break;
                }
                count++;
            }
            count = 0;
            // 오른쪽
            for (int j = temp.x; j >= 0; j--) {
                if(j== 0){
                    checklist[1] = count;
                    break;
                }else if(map[temp.y][j] == 6){
                    checklist[1] = count-1;
                    break;
                }
                count++;
            }
            count = 0;
            // 아래
            for (int j = temp.y; j < map.length; j++) {
                if(j== map.length-1){
                    checklist[2] = count;
                    break;
                }else if(map[j][temp.x] == 6){
                    checklist[2] = count-1;
                    break;
                }
                count++;
            }
            count = 0;
            // 위
            for (int j = temp.y; j >= 0; j--) {
                if(j == 0){
                    checklist[3] = count;
                    break;
                }else if(map[j][temp.x] == 6){
                    checklist[3] = count-1;
                    break;
                }
                
                count++;
            }
            System.out.println("check :"+ Arrays.toString(checklist));
            
            for (int i = 0; i < checklist.length; i++) {
                
            }
        }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        
        map = new int[N][M];
        test = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st =new StringTokenizer(sc.nextLine()," ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6){
                    test.add(new cctv(i,j,map[i][j]));
                }
            }
        }

        for (int i = 0; i < test.size(); i++) {
            search(test.get(i));
        }
    }
}
