import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj21610 {
    public static int[][] map;
    public static boolean[][] visited;
    public static ArrayList<int[]> clouds;
    public static ArrayList<int[]> magic;
    public static int[] dirY = {0,-1,-1,-1,0,1,1,1};
    public static int[] dirX = {-1,-1,0,1,1,1,0,-1};
    public static int[] angledirY = {-1,-1,1,1};
    public static int[] angledirX = {-1,1,1,-1};

    public static void moving(){
        for(int[] order : magic){
            int dir = order[0];
            int move = order[1];

            for(int idx = 0; idx<clouds.size(); idx++){
                int checkY = (clouds.get(idx)[0]+(dirY[dir]*(move%map.length)))%map.length;
                int checkX = (clouds.get(idx)[1]+(dirX[dir]*(move%map.length)))%map.length;
                if(checkY < 0){
                    checkY = map.length + checkY;
                }
                if(checkX < 0){
                    checkX = map.length + checkX;
                }
                clouds.set(idx,new int[]{checkY, checkX});
            }
            // for(int[] temp : map){
            //     System.out.println(Arrays.toString(temp));
            // }
            // System.out.println("=================================");
            raining();
        }
    }

    public static void raining(){
        for(int[] single : clouds){
            map[single[0]][single[1]]++;
            visited[single[0]][single[1]] = true;
        }        
        // System.out.println("==============rain=============");
        // for(int[] temp : map){
        //     System.out.println(Arrays.toString(temp));
        // }
        //     System.out.println("=================================");
        for(int[] single : clouds){
            for(int i=0; i< 4; i++){
                if(single[0]+angledirY[i] >= 0 && single[0]+angledirY[i] <map.length &&single[1]+angledirX[i] >= 0 && single[1]+angledirX[i] <map.length && map[single[0]+angledirY[i]][single[1]+angledirX[i]] > 0){
                    map[single[0]][single[1]]++;
                }
            }
        }

        // System.out.println("=========== MORE rain=============");
        // for(int[] temp : map){
        //     System.out.println(Arrays.toString(temp));
        // }
        // System.out.println("=================================");

        ArrayList<int[]> newClouds = new ArrayList<>();
        for(int i=0; i< map.length; i++){
            for(int j=0; j< map.length; j++){
                if(!visited[i][j] && map[i][j] > 1){
                    newClouds.add(new int[]{i,j});
                    map[i][j] -= 2;
                }
            }
        }
        // System.out.println("=========== last =============");
        // for(int[] temp : map){
        //     System.out.println(Arrays.toString(temp));
        // }
        // for(int [] temp : newClouds){
        //     System.out.print(Arrays.toString(temp));
        // }
        // System.out.println();
        // System.out.println("=================================");
        clouds = newClouds;
        visited = new boolean[map.length][map.length];
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        magic = new ArrayList<>();
        clouds = new ArrayList<>();
        for(int i=0; i< N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j < N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int dir = Integer.parseInt(st.nextToken())-1;
            int move = Integer.parseInt(st.nextToken());
            magic.add(new int[]{dir, move});
        }
        clouds.add(new int[]{N-1,0});
        clouds.add(new int[]{N-1,1});
        clouds.add(new int[]{N-2,0});
        clouds.add(new int[]{N-2,1});
        moving();

        int solution = 0;
        for(int i=0; i< map.length; i++){
            for(int j=0; j< map.length; j++){
                solution+= map[i][j];
            }
        }
        System.out.println(solution);
    }  
}
