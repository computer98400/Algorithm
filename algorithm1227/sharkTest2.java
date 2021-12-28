package Algorithm.algorithm1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class sharkTest2 {
    
    public static int[][] map = {{1,2,3,4},{0,0,0,0},{0,0,0,0},{4,3,2,1}};
    public static boolean[][] visited;
    static class posSize{
        int y;
        int x;
        int size;

        posSize(int y, int x, int size){
            this.y= y;
            this.x = x;
            this.size = size;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        
        int sharkSize = 2;
        int sharkCount = 0;
        int fishes = 0;
        int N = Integer.parseInt(br.readLine());
        

        map = new int[N][N];
        visited = new boolean[N][N];

        ArrayList<posSize> fishesarr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    fishes++;
                    fishesarr.add(new posSize(i,j, map[i][j]));
                }
            }
        }
        while(true){   
            if(fishes == 0 || fishesarr.get(0).size > sharkSize){
                System.out.println(sharkSize +" "+sharkCount);
                break;
            }
            test : for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if(map[i][j] != 0 &&  map[i][j] < sharkSize){
                        map[i][j] = 0;
                        sharkCount++;
                        fishes--;
                        fishesarr.remove(0);
                        visited[i][j] = true;
                        for (int k = 0; k < 4; k++) {
                            System.out.println(Arrays.toString(map[k]));
                        }
                        if(sharkCount == sharkSize){
                            sharkSize++;
                            sharkCount = 0;
                        }
                        visited = new boolean[4][4];
                        break test;
                    }
                }
            }
        }
    }
}
