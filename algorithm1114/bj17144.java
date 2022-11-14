import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj17144 {
    public static int[][] map;
    public static int[] dirY = {0,-1,0,1};
    public static int[] dirX = {1,0,-1,0};

    public static int R;
    public static int C;
    public static int T;

    public static int first;
    public static int second;

    public static ArrayList<int[]> diffusion(ArrayList<int[]> list){
        ArrayList<int[]> output = new ArrayList<>();

        for(int i=0; i< list.size(); i++){
            int count =0;

            //주변에 칸 확인
            for(int j =0; j< 4; j++){
                int tempY = list.get(i)[0]+dirY[j];
                int tempX = list.get(i)[1]+dirX[j];

                if(tempY <0 || tempX <0 || tempY >=map.length || tempX >= map[0].length || map[tempY][tempX] < 0) continue;
                count++;

            }

            for(int j=0; j<4; j++){
                int tempY = list.get(i)[0]+dirY[j];
                int tempX = list.get(i)[1]+dirX[j];

                if(tempY <0 || tempX <0 || tempY >=map.length || tempX >= map[0].length || map[tempY][tempX] < 0) continue;

                output.add(new int[]{tempY,tempX,list.get(i)[2]/5});
            }
            output.add(new int[]{list.get(i)[0], list.get(i)[1], list.get(i)[2] - list.get(i)[2]/5*count});
        }
        return output;

    }

    public static void cleaning(int first, int second){
        //first의 경우 위쪽 공기청정기
        //시작[2][1] -> 끝[1][0] 까지의 1차원배열을 만들기.
        Queue<Integer> que = new LinkedList<>();
        for(int i=first-1; i>= 0; i--){
            que.add(map[i][0]);
        }

        for(int i=1; i<C; i++){
            que.add(map[0][i]);
        }

        for(int i=1; i<first; i++){
            que.add(map[i][C-1]);
        }

        for(int i=C-1; i>0;i--){
            que.add(map[first][i]);
        }
        que.poll();
        que.offer(0);


        for(int i=first-1; i >=0; i--){
            map[i][0] = que.poll();
//            map[i][0] = 0;
        }

        for(int i =1; i<C; i++){
            map[0][i] = que.poll();
//            map[0][i] = 0;
        }
        for(int i=1; i< first; i++){
            map[i][C-1] = que.poll();
//            map[i][map.length] = 0;
        }
        for(int i= C-1; i>0; i--){
            map[first][i] = que.poll();
//            map[first][i] = 0;
        }

        //second의 경우 아래쪽 공기청정기
        que = new LinkedList<>();
        for(int i=second+1; i< R; i++){
            que.add(map[i][0]);
        }
        for(int i=1; i<C; i++){
            que.add(map[R-1][i]);
        }
        for(int i=R-2; i>=second; i--){
            que.add(map[i][C-1]);
        }

        for(int i=C-2; i>0;i--){
            que.add(map[second][i]);
        }
//        System.out.println(que.toString());
        que.poll();
        que.offer(0);
//        System.out.println(que.toString());
        for(int i=second+1; i< R; i++){
            map[i][0] = que.poll();
        }
        for(int i=1; i<C; i++){
            map[R-1][i] = que.poll();
        }
        for(int i=R-2; i>=second; i--){
            map[i][C-1] = que.poll();
        }

        for(int i=C-2; i>0;i--){
            map[second][i] = que.poll();
        }

//        System.out.println(que.toString());
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int solution = 0;
        map = new int[R][C];
        ArrayList<int[]> origin = new ArrayList<>();
        for(int i=0; i< R; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j =0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    first = i;
                }
            }
        }




        for(int i=0; i<T; i++){
            origin = new ArrayList<>();
            for(int j=0; j< map.length; j++){
                for(int q = 0; q<map[0].length; q++){
                    if(map[j][q] > 0){
                        origin.add(new int[]{j,q,map[j][q]});
                    }
                }
            }

            origin = diffusion(origin);
            map = new int[R][C];
            for(int[] temp : origin){
                map[temp[0]][temp[1]]+= temp[2];
            }
            cleaning(first-1,first);
            map[first-1][0] = -1;
            map[first][0] = -1;

        }
        for(int[] temp : map){
            for(int k=0; k <temp.length;k++){
                if(temp[k] > 0){
                    solution+= temp[k];
                }
            }
        }
        System.out.println(solution);
    }


}
