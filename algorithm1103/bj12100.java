import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj12100 {
    public static int count =0;
    public static int[][] origin;
    public static int[][] copy;
    public static int size;
    public static int solution = 0;
    public static void combi(int current, int[] output){
        if(current == 5){
            calculation(output);

            for(int i=0; i< size; i++){
                for(int j=0; j< size; j++){
                    solution = Math.max(solution, copy[i][j]);
                }
            }

            for(int i=0; i< size; i++){
                for(int j=0; j< size; j++){
                    copy[i][j] = origin[i][j];
                }
            }
            return;
        }

        for(int i=0; i<4; i++){
            output[current] = i;
            combi(current+1,output);
        }


    }



    public static void calculation(int[] dir){
        for(int temp : dir){
            if(temp == 0){
                for(int i=0;i<size; i++){
                    moveLeftandUP(copy[i], i, "left");
                }
            }else if(temp == 1){
                int[] check = new int[size];
                for(int j =0; j< size; j++){
                    for(int i=0; i< size; i++){
                        check[i] = copy[i][j];
                    }
                    moveLeftandUP(check, j, "up");
                }
            }else if(temp == 2){
                for(int i=0;i<size; i++){
                    moveRightandDown(copy[i], i, "right");
                }
            }else if(temp == 3){
                int[] check = new int[size];
                for(int j =0; j< size; j++){
                    for(int i=0; i< size; i++){
                        check[i] = copy[i][j];
                    }
                    moveRightandDown(check, j, "down");
                }
            }
        }

    }
    //각 방향으로 합쳐질 경우 반대 방향에서부터 값을 읽어가면 표현하면 됨.
    //위로 이동시 = [0][x] -> [size][x] + 중간에 0을 만났을 때 확인해야됨.0 갯수만큼 넘어가주고,
    //아래로 이동시 = [size][x] -> [0][x]
    //오른쪽으로 이동시 = [x][size] -> [x][0]
    //왼쪽으로 이동시 = [x][0] -> [x][size]
    public static void moveLeftandUP(int[] map, int floor, String dir){
        int originIDX = 0;
        int compareIDX = 0;
        int[] temp = new int[map.length];
        while(originIDX != map.length){
            if(map[originIDX] != 0){
                if(temp[compareIDX] == 0){
                    temp[compareIDX] = map[originIDX];
                    originIDX++;
                    continue;
                }
                //원본 배열의 originIDX와 새로만들어질 배열의 compareIDX가 같다면
                if(map[originIDX] == temp[compareIDX]){
                    temp[compareIDX] *= 2;
                    compareIDX++;
                }else{
                    compareIDX++;
                    temp[compareIDX] = map[originIDX];
                }
            }
            originIDX++;
        }

        if(dir == "up"){
            for(int i=0; i<temp.length; i++){
                copy[i][floor] = temp[i];
            }
        }else if(dir == "left"){
            for(int i=0; i<temp.length; i++){
                copy[floor][i] = temp[i];
            }
        }
    }

    public static void moveRightandDown(int[] map, int floor, String dir){
        int originIDX = map.length-1;
        int compareIDX = map.length-1;
        int[] temp = new int[map.length];
        while(originIDX != -1){
            if(map[originIDX] != 0){
                if(temp[compareIDX] == 0){
                    temp[compareIDX] = map[originIDX];
                    originIDX--;
                    continue;
                }
                //원본 배열의 originIDX와 새로만들어질 배열의 compareIDX가 같다면
                if(map[originIDX] == temp[compareIDX]){
                    temp[compareIDX] *= 2;
                    compareIDX--;
                }else{
                    compareIDX--;
                    temp[compareIDX] = map[originIDX];
                }
            }
            originIDX--;
        }
        if(dir == "down"){
            for(int i=0; i<temp.length; i++){
                copy[i][floor] = temp[i];
            }
        }else if(dir == "right"){
            for(int i=0; i<temp.length; i++){
                copy[floor][i] = temp[i];
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        origin = new int[size][size];
        copy = new int[size][size];
        StringTokenizer st;
        for(int i=0; i< size;i++){
            st= new StringTokenizer(br.readLine()," ");

            for(int j=0; j<size;j++){
                int number = Integer.parseInt(st.nextToken());
                origin[i][j] = number;
                copy[i][j] = number;
            }
        }
        combi(0,new int[5]);

        System.out.println(solution);
    }
}
