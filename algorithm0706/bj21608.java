import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj21608 {

    public static int[] dirY = {0,0,1,-1};
    public static int[] dirX = {1,-1,0,0};
    public static seatInfo[][] map;
    public static boolean[][] positied;
    static class seatInfo{
        int oner;
        ArrayList<Integer> lovers;
        seatInfo(){
            this.oner = 0;
            this.lovers = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "["+this.oner+" "+this.lovers.toString()+"]";
        }
    }


    //tempMap을 통해서 각 자리중 좋아하는 학생이 인접한 경우를 모두 표현.
    //자리에 사람이 있으면 -1
    public static void blankSeat(int oner,ArrayList<Integer> lovers){
        int[][] tempMap = new int[map.length][map.length];
        int[][] tempBlankMap = new int[map.length][map.length];
        int higher = 0;

        for(int i=0;i< map.length;i++){
            for(int j=0;j< map.length;j++){
                int tempBlank = 0;
                for(int q=0; q<4;q++){
                    if(i+dirY[q] >= 0 && i+dirY[q] < map.length && j+dirX[q] >= 0 && j+dirX[q] < map.length && !positied[i][j]){
                        if(lovers.contains(map[i+dirY[q]][j+dirX[q]].oner)){
                            tempMap[i][j]++;
                            if(tempMap[i][j] > higher){
                                higher = tempMap[i][j];
                            }
                        }else if(map[i+dirY[q]][j+dirX[q]].oner == 0){
                            tempBlankMap[i][j]++;
                        }
                    }
                }
            }
        }
        ArrayList<int[]> selected = new ArrayList<>();
        for(int i=0; i< map.length;i++){
            for(int j=0; j< map.length;j++){
                if(tempMap[i][j] == higher && !positied[i][j]){
                    selected.add(new int[]{tempBlankMap[i][j],i,j});
                }
            }
        }
        Collections.sort(selected, (o1, o2) -> o1[0]!=o2[0] ? o2[0]-o1[0] : (o1[1]!=o2[1] ? o1[1]-o2[1] : o1[2]-o2[2]));
        map[selected.get(0)[1]][selected.get(0)[2]].oner = oner;
        map[selected.get(0)[1]][selected.get(0)[2]].lovers = lovers;
        positied[selected.get(0)[1]][selected.get(0)[2]]  = true;
//        for(seatInfo[] temp : map){
//            System.out.println(Arrays.toString(temp));
//        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new seatInfo[N][N];

        positied = new boolean[N][N];

        for(int i=0; i< N;i++){
            for(int j=0; j< N;j++){
                map[i][j] = new seatInfo();
            }
        }

        StringTokenizer st;
        for(int i=0; i< N*N;i++){
            st =new StringTokenizer(br.readLine(), " ");
            int oner = Integer.parseInt(st.nextToken());
            ArrayList<Integer> lovers = new ArrayList<>();
            for(int j=0; j< 4;j++){
                lovers.add(Integer.parseInt(st.nextToken()));
            }
            blankSeat(oner, lovers);
        }

        int solution = 0;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                int cnt = 0;
                for(int q=0; q<4; q++){
                    if(i+dirY[q] >= 0 && i+dirY[q] < map.length && j+dirX[q] >= 0 && j+dirX[q] < map.length){
                        if(map[i][j].lovers.contains(map[i+dirY[q]][j+dirX[q]].oner)){
                            cnt++;
                        }

                    }
                }
                if(cnt == 1){
                    solution+= 1;
                }else if(cnt == 2){
                    solution+= 10;
                }else if(cnt == 3){
                    solution+= 100;
                }else if(cnt == 4){
                    solution+= 1000;
                }
            }
        }
        System.out.println(solution);
    }
}
