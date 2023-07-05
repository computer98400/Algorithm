import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj19236 {
    //priority 순서
    //0 : 위쪽
    //1 : 아래쪽
    //2 : 왼쪽
    //3 : 오른쪽
    public static int k;
    public static int[] dirY = {-1,1,0,0};
    public static int[] dirX = {0,0,-1,1};
    public static mapinfo[][] map;
    public static ArrayList<shark> sharks;

    static class mapinfo{
        int smell;
        int sharknumber;

        mapinfo(){
            this.smell = 0;
            this.sharknumber = -1;
        }

        mapinfo(int smell, int number){
            this.smell= smell;
            this.sharknumber = number;
        }
    }

    static class shark{
        int currentdir;
        int number;
        int y;
        int x;
        boolean arrive = false;
        int[] priority;


        shark(int number,int y, int x, int dir){
            this.number = number;
            this.y = y;
            this.x = x;
            this.currentdir = dir;
            this.arrive = true;
        }


        void addPriority(int[] input){
            this.priority = input;
        }

        void changeDir(int input){
            this.currentdir = input;
        }
        void dead(){
            this.arrive = false;
        }
        public String toString(){
            return "Shark info [ number : "+this.number+" / position : "+this.y+" "+this.x+" / dir : "+this.currentdir+" / priority : "+Arrays.toString(this.priority);
        }

    }
    //겹치는 상어가 존재하는지 확인하는 로직
    public static int fight(){
        int[][] tempMap = new int[map.length][map.length];
        for(int[] single : tempMap){
            Arrays.fill(single,-1);
        }


        for(shark temp : sharks){
            if(tempMap[temp.y][temp.x] == -1){
                tempMap[temp.y][temp.x] = temp.number;
            }else{
                if(tempMap[temp.y][temp.x] < temp.number){
                    sharks.get(temp.number).dead();
                }
            }    
        }
        int count=0;
        for(int i=0; i< map.length; i++){
            for(int j=0; j< map.length; j++){
                if(tempMap[i][j] != -1){
                    count++;
                }
            }
        }


        return count;
    }


    //상어의 냄새가 남기는 로직
    public static void spread(){
        for(shark single : sharks){
            if(single.arrive){
                map[single.y][single.x].smell = k;
                map[single.y][single.x].sharknumber = number;
            }
        }
    }

    //냄새가 사라지는 로직
    //1->0이 된다면 vistied = false
    public static void clean(){
        for(int i=0; i< map.length; i++){
            for(int j=0; j<map.length;j++){
                if(map[i][j].smell != 0){
                    map[i][j].smell--;
                }
            }
        }

    }
    public static void move(){
        for(shark single : sharks){
            if(single.arrive){
                single.y += dirY[single.currentdir];
                single.x += dirX[single.currentdir];
            }
        }
    }

    //상어가 방향을 정하는 로직
    public static void adjustDir(){
        for(shark single : sharks){
            int[] tempdirY = new int[4];
            int[] tempdirX = new int[4];

            for(int i=0; i< 4;i++){
                tempdirX[i] = dirX[single.priority[single.currentdir*4+i]];
                tempdirY[i] = dirY[single.priority[single.currentdir*4+i]];
            }

            if(single.arrive){
                boolean flag = false;
                for(int i=0; i<4; i++){
                    if(single.y+tempdirY[i] >= 0 && single.y+tempdirY[i] < map.length && single.x+tempdirX[i] >= 0 && single.x+tempdirX[i] < map.length && map[single.y+tempdirY[i]][single.x+tempdirX[i]].smell == 0){
                        single.changeDir(i);
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    for(int i=0; i<4; i++){
                        if(single.y+tempdirY[i] >= 0 && single.y+tempdirY[i] < map.length && single.x+tempdirX[i] >= 0 && single.x+tempdirX[i] < map.length && map[single.y+tempdirY[i]][single.x+tempdirX[i]].sharknumber == single.number){
                            single.changeDir(i);
                            break;
                        }
                    }    
                }
            }
        }
    }


    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sharks = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] positions = new int[M+1][3];
        map = new mapinfo[N][N];
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j< N;j++){
                int sharknumber = Integer.parseInt(st.nextToken());
                if(sharknumber != 0){
                    positions[sharknumber] = new int[]{i,j,0};
                }
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int idx =0;
        while(st.hasMoreTokens()){
            idx++;
            int dir = Integer.parseInt(st.nextToken());
            positions[idx][2] = dir-1;
            sharks.add(new shark(idx, positions[idx][0], positions[idx][1], positions[idx][2]));
        }
        for(int i=0; i<M; i++){
            String temp = "";
            for(int j=0; j< 4; j++){
                temp += br.readLine()+" ";
            }
            st = new StringTokenizer(temp, " ");
            int[] priority = new int[16];
            for(int q=0; q <priority.length;q++){
                priority[q] = Integer.parseInt(st.nextToken())-1;
            }
            sharks.get(i).addPriority(priority);
        }

        int solution = 0;

        while(true){
            if(solution > 999){
                solution = -1;
                break;
            }






            solution++;
        }

    }
}
