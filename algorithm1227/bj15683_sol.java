import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15683 {


    //4에 해당하는 값으로 조합 만들기.
    //만약 type값이 2, 5라면 다른 조건으로 추가해야됨. 2 = 2까지만, 5라면 0
    public static int[][] map;
    public static ArrayList<Integer> type = new ArrayList<>();
    public static ArrayList<int[]> position = new ArrayList<>();
    public static ArrayList<int[]> wallpos = new ArrayList<>();
    public static int[] dirX = {0,-1,0,1};
    public static int[] dirY = {1,0,-1,0};
    public static int R;
    public static int C;
    public static int solution=Integer.MAX_VALUE;
    //방향 결정하는 함수
    public static void combo(int idx, int[] number){
        if(idx == number.length){
            fill(number);
            return;
        }

        if(type.get(idx) == 5) {
            number[idx] = 0;
            combo(idx+1, number);
        }else if(type.get(idx) == 2){
            for(int i=0; i<2; i++){
                number[idx] = i;
                combo(idx+1, number);
            }
        }else{
            for(int i=0; i<4; i++){
             number[idx] = i;
             combo(idx+1, number);
            }
        }
    }

    public static void fill(int[] directions){
        for(int i=0; i< directions.length; i++){
            watch(type.get(i), directions[i], position.get(i)[0], position.get(i)[1]);
        }
        int count=0;
        for(int[] temp : map){
            for(int temp2 : temp){
                if(temp2 == 0){
                    count++;
                }
            }
        }
        solution = Math.min(solution,count);
        map = new int[R][C];
        for(int[] temp : wallpos){
            map[temp[0]][temp[1]] = 6;
        }
    }

    //칠하는 함수
    public static void watch(int type,int dir, int y, int x) {

        if(type == 5){
            for(int k=0; k<4; k++){
                if(k == 0 || k== 2){
                    for(int i = y;; i+=dirY[k]){
                        if(i <0  || i >= map.length|| map[i][x] == 6){
                            break;
                        }
                        map[i][x] = -1;
                    }
                }else{
                    for(int i = x;; i+=dirX[k]){
                        if(i <0  || i >= map[0].length|| map[y][i] == 6){
                            break;
                        }
                        map[y][i] = -1;
                    }
                }
            }
        }else if(type== 4){
           for(int k=0; k<4; k++){
               if(k == dir){
                   continue;
               }
               if(k == 0 || k== 2){
                   for(int i = y;; i+=dirY[k]){
                       if(i <0  || i >= map.length|| map[i][x] == 6){
                           break;
                       }
                       map[i][x] = -1;
                   }
               }else{
                   for(int i = x;; i+=dirX[k]){
                       if(i <0  || i >= map[0].length|| map[y][i] == 6){
                           break;
                       }
                       map[y][i] = -1;
                   }
               }
           }
       }else if(type ==3){
           for(int k=0; k<4; k++){
               if(k == dir || k == ((dir+1)%4)){
                   continue;
               }
               if(k == 0 || k== 2){
                   for(int i = y;; i+=dirY[k]){
                       if(i <0  || i >= map.length|| map[i][x] == 6){
                           break;
                       }
                       map[i][x] = -1;
                   }
               }else{
                   for(int i = x;; i+=dirX[k]){
                       if(i <0  || i >= map[0].length|| map[y][i] == 6){
                           break;
                       }
                       map[y][i] = -1;
                   }
               }
           }
       }else if(type ==2){
           for(int k=0; k<4; k++){
               if(k == dir || k == ((dir+2)%4)){
                   continue;
               }
               if(k == 0 || k== 2){
                   for(int i = y;; i+=dirY[k]){
                       if(i <0  || i >= map.length|| map[i][x] == 6){
                           break;
                       }
                       map[i][x] = -1;
                   }
               }else{
                   for(int i = x;; i+=dirX[k]){
                       if(i <0  || i >= map[0].length|| map[y][i] == 6){
                           break;
                       }
                       map[y][i] = -1;
                   }
               }
           }
       }else if(type == 1){
           for(int k=0; k<4; k++){
               if(k != dir){
                   continue;
               }
               if(k == 0 || k== 2){
                   for(int i = y;; i+=dirY[k]){
                       if(i <0  || i >= map.length|| map[i][x] == 6){
                           break;
                       }
                       map[i][x] = -1;
                   }
               }else{
                   for(int i = x;; i+=dirX[k]){
                       if(i <0  || i >= map[0].length|| map[y][i] == 6){
                           break;
                       }
                       map[y][i] = -1;
                   }
               }
           }
       }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int i=0; i< R; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<C; j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(map[i][j] != 0 && map[i][j] != 6){
                    position.add(new int[]{i,j});
                    type.add(temp);
                }
                if(temp == 6){
                    wallpos.add(new int[]{i,j});
                }
            }
        }
        combo(0,new int[type.size()]);

        System.out.println(solution);
    }
}
