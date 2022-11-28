import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj17143 {

    public static int Xsize = 0;
    public static int Ysize = 0;
    public static ArrayList<shark> sharklist = new ArrayList<>();
    public static shark[][] map;
    static class shark{
        int y;
        int x;
        int move;
        int dir;
        int size;

        shark(int y, int x, int move, int dir, int size){
           this.y = y;
           this.x = x;
           this.move = move;
           this.dir = dir;
           this.size = size;
        }

        @Override
        public String toString() {
            return this.y+" "+this.x+" move : "+this.move+" dir : "+this.dir+" size : "+this.size;
        }
    }
    //인풋 x, size, dir
    public static shark move(shark target){

        int y = target.y;
        int x = target.x;
        int dir = target.dir;
        int move = target.move;
        int sharkSize = target.size;


        int current = dir == 1 || dir == 2 ? y : x;
        boolean before = dir == 2 || dir == 3;
        boolean after = dir == 2 || dir == 3;

        int size = dir == 1 || dir == 2 ? Ysize : Xsize;
        int lastMove = (move%((size-1)*2));
        for(int count=0;count<lastMove;){
            if(after){
                current++;
            }else{
                current--;
            }

            if(current >= size || current < 0){
                after = !after;
            }
            if(current == size){
                current--;
                current--;
            }
            if(current == -1){
                current++;
                current++;
            }
            count++;
        }

        if(before != after){
            if(dir == 4){
                return new shark(y,current, move, 3, sharkSize);
            }else if(dir == 1){
                return new shark(current,x, move, 2, sharkSize);
            }else if(dir == 2){
                return new shark(current,x, move, 1, sharkSize);
            }else if(dir == 3){
                return new shark(y,current, move, 4, sharkSize);
            }
        }else{
            if(dir == 4 || dir == 3){
                return new shark(y,current, move, dir, sharkSize);
            }else {
                return new shark(current,x, move, dir, sharkSize);
            }
        }

        return new shark(0,0,0,0,0);
    }
    public static int solution = 0;

    public static void fishing(int pos){
        for(int i=0; i< Ysize; i++){
            if(map[i][pos] != null){
                solution += map[i][pos].size;
                map[i][pos] = null;
                return;
            }
        }
    }

    public static void scan(){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] != null){
                    sharklist.add(map[i][j]);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        Ysize = Integer.parseInt(st.nextToken());
        Xsize = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new shark[Ysize][Xsize];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int R = Integer.parseInt(st.nextToken())-1;
            int C = Integer.parseInt(st.nextToken())-1;
            int move = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            sharklist.add(new shark(R,C,move,dir,size));
        }

        for(shark temp : sharklist){
            map[temp.y][temp.x] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< Xsize; i++){
            fishing(i);
            sharklist = new ArrayList<>();
            scan();
            map = new shark[Ysize][Xsize];
            for(shark temp : sharklist){
                shark output = move(temp);

                if(map[output.y][output.x] != null){
                    if(map[output.y][output.x].size < output.size){
                        map[output.y][output.x] = output;
                    }
                }else{
                    map[output.y][output.x] = output;
                }
            }
//            sb = new StringBuilder();
//            for(int j=0; j<map.length; j++){
//                for(int k=0; k< map[0].length;k++){
//                    if(map[j][k] != null){
//                        sb.append(map[j][k].size).append(" ");
//                    }else{
//                        sb.append(0).append(" ");
//                    }
//                }
//                sb.append("\n");
//            }
//
//            System.out.println(sb);
//            System.out.println("==============================");

        }
        System.out.println(solution);



    }
}
