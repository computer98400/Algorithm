

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16234{
    public static int[][] map;
    public static boolean[][] visited;
    public static Queue<int[]> que;
    public static int max;
    public static int min;
    

    public static int[] diry = {0,0,1,-1};
    public static int[] dirx = {-1,1,0,0};

    public static int bfs(int y, int x){
        que.offer(new int[]{y,x});
        ArrayList<int[]> list = new ArrayList<>();
        visited[y][x] = true;
        list.add(new int[]{y,x});

        while(!que.isEmpty()){
            int[] temp = que.poll();
            for(int i =0;i<4; i++){
                int tempy= temp[0]+diry[i];
                int tempx= temp[1]+dirx[i];

                if(tempy >=0 && tempx >= 0 && tempy < map.length&& tempx < map.length && !visited[tempy][tempx] && cal(map[temp[0]][temp[1]],map[tempy][tempx])){
                    list.add(new int[]{tempy,tempx});
                    que.offer(new int[]{tempy,tempx});
                    visited[tempy][tempx] = true;
                }
            }
        }

        int avg = 0;

        if(list.size()>= 2){
            for(int[] temp : list){
                avg+= map[temp[0]][temp[1]];
            }
            
            avg = avg/list.size();
            // for (int[] is : list) {
            //     System.out.print(Arrays.toString(is)+" ");
            // }
            // System.out.println();
            // System.out.println(list.size()+" "+avg);
            for(int[] temp : list){
                map[temp[0]][temp[1]] = avg;
            }
            return 1;
        }else{
            return 0;
        }  
    }
    
    public static boolean cal(int origin, int temp){
        if(Math.abs(origin-temp) >= min && Math.abs(origin-temp) <= max ){
         return true;
        }else{
         return false;
        }
     }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
            
        que = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0; j< N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int days = 0;
        while(true){
            int total = 0;
            for(int i=0; i< N; i++){
                for(int j=0;j< N; j++){
                    if(visited[i][j]){
                        continue;
                    }

                    if(bfs(i,j) == 1){
                        total += 1;
                    }
                }
            }
            visited = new boolean[N][N];

            if(total == 0){
                System.out.println(days);
                break;
            }
            // for (int[] temp : map) {
            //     System.out.println(Arrays.toString(temp));
            // }
            // System.out.println("------------------");

            days++;
        }

    }

}
