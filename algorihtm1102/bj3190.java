import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj3190 {
    public static int[] dirY= {0,-1,0,1};
    public static int[] dirX= {1,0,-1,0};
    public static int dir =0;
    public static int len = 1;
    public static int posY;
    public static int posX;
    public static int count = 1;
    public static void turn(String sign){
        if(sign.equals("L")){
            dir = (dir+1)%4;
        }else if(sign.equals("D")){
            dir -= 1;
            if(dir == -1){
                dir = 3;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] map = new int[size][size];
        int apples = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i< apples; i++){
            st = new StringTokenizer(br.readLine()," ");
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 999;
        }

        int moves = Integer.parseInt(br.readLine());
        Queue<Integer> moveQue = new LinkedList<>();
        Queue<String> turnQue = new LinkedList<>();
        for(int i=0; i<moves; i++){
            st = new StringTokenizer(br.readLine()," ");
            moveQue.offer(Integer.parseInt(st.nextToken()));
            turnQue.offer(st.nextToken());
        }
        int change = 0;
        String turn = "";
        while(true){
            if(change == 0 && !moveQue.isEmpty()){
                change = moveQue.poll();
                turn = turnQue.poll();
            }
            posY +=dirY[dir];
            posX +=dirX[dir];
            if(posY <0 || posX < 0 || posY >= size || posX >= size){
                break;
            }

            if(map[posY][posX] != 0){
                if(map[posY][posX] == 999){
                    len++;
                }else if(map[posY][posX] >= count-len){
                    break;
                }
            }
            if(count == change){
                turn(turn);
                change = 0;
                turn = "";
            }
            map[posY][posX] = count++;
        }
        System.out.println(count);

    }
}
