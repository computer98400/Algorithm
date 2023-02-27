import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj16935 {
    public static int[][] origin;
    public static node[][] indexes;
    public static int N;
    public static int M;
    static class node{
        int y;
        int x;
        int sector;
        node(int y, int x, int sector){
            this.y= y;
            this.x= x;
            this.sector = sector;
        }
        void process1(){
            this.y = N-1-this.y;
            if(this.sector == 0){
                this.sector = 3;
            }else if(this.sector == 1){
                this.sector = 2;
            }else if(this.sector == 2){
                this.sector = 1;
            }else if(this.sector == 3){
                this.sector = 0;
            }


        }
        void process2(){
            this.x = M-1-this.x;
            if(this.sector == 0){
                this.sector = 1;
            }else if(this.sector == 1){
                this.sector = 0;
            }else if(this.sector == 2){
                this.sector = 3;
            }else if(this.sector == 3){
                this.sector = 2;
            }

        }

        void process3(){
            int temp = this.x;
            this.x = M-1-this.y;
            this.y = temp;
            this.sector = (this.sector+1)%4;
        }
        void process4(){
            int temp = this.y;
            this.y = N-1-this.x;
            this.x = temp;
            if(this.sector == 0){
                this.sector = 3;
            }else{
                this.sector = Math.abs(this.sector-1)%4;
            }
        }

        void process5(){
            if(this.sector == 0){
                this.x += M/2;
            }else if(this.sector == 1){
                this.y += N/2;
            }else if(this.sector == 2){
                this.x -= M/2;
            }else if(this.sector == 3){
                this.y -= N/2;
            }
            this.sector = (this.sector+1)%4;
        }

        void process6(){
            if(this.sector == 0){
                this.y += N/2;
            }else if(this.sector == 1){
                this.x -= M/2;
            }else if(this.sector == 2){
                this.y -= N/2;
            }else if(this.sector == 3){
                this.x += M/2;
            }
            if(this.sector == 0){
                this.sector = 3;
            }else{
                this.sector = Math.abs(this.sector-1)%4;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int orderCnt = Integer.parseInt(st.nextToken());
        origin = new int[N][M];
        indexes = new node[N][M];
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j< M; j++){
                origin[i][j] = Integer.parseInt(st.nextToken());
                if(i < N/2 && j < M/2){
                    indexes[i][j] = new node(i,j,0);
                }else if(i >= N/2 && j < M/2){
                    indexes[i][j] = new node(i,j,3);
                }else if(i < N/2 && j >= M/2){
                    indexes[i][j] = new node(i,j,1);
                }else if(i >= N/2 && j >= M/2){
                    indexes[i][j] = new node(i,j,2);
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()){
            int order = Integer.parseInt(st.nextToken());
            if(order == 3 || order == 4){
                int temp =N;
                N = M;
                M = temp;
            }
            if(order == 1){
                for(int i=0; i<indexes.length; i++){
                    for(int j=0; j<indexes[0].length; j++) {
                        indexes[i][j].process1();
                    }
                }
            }else if(order == 2){
                for(int i=0; i<indexes.length; i++){
                    for(int j=0; j<indexes[0].length; j++) {
                        indexes[i][j].process2();
                    }
                }
            }else if(order ==3){
                for(int i=0; i<indexes.length; i++){
                    for(int j=0; j<indexes[0].length; j++) {
                        indexes[i][j].process3();
                    }
                }
            }else if(order ==4){
                for(int i=0; i<indexes.length; i++){
                    for(int j=0; j<indexes[0].length; j++) {
                        indexes[i][j].process4();
                    }
                }
            }else if(order == 5){
                for(int i=0; i<indexes.length; i++){
                    for(int j=0; j<indexes[0].length; j++) {
                        indexes[i][j].process5();
                    }
                }
            }else if(order ==6){
                for(int i=0; i<indexes.length; i++){
                    for(int j=0; j<indexes[0].length; j++) {
                        indexes[i][j].process6();
                    }
                }
            }
        }
        int[][] copy = new int[N][M];

        for(int i=0; i< indexes.length;  i++){
            for(int j=0; j< indexes[0].length; j++){
//                System.out.println(indexes[i][j].y+" "+indexes[i][j].x);
                copy[indexes[i][j].y][indexes[i][j].x] = origin[i][j];
            }
        }
        StringBuilder sb =new StringBuilder();
        for(int[] temp : copy){
            for(int i =0; i< temp.length; i++){
                sb.append(temp[i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());

        //1 -> 상하
        //origin length값과, origin[0].length 값은 3,4번 동작에 의해 계속해서 변경됨. -> 변경됨을 체크하는 변수 필요.

        // 상하의 경우 현재 y값이 반전됨을 의미.
        // 상하 반전 -> (origin.length-1-y),x

        //?? 상하반전을 한뒤 시계방향으로 돌린다면?



        // 좌우의 경우 현재 x값의 반전됨을 의미.
        // 좌우 반전 -> y,(origin[0].length-1-x)

        // 3번의 경우 x,y값의 자리가 변하고, x값이 반전을 의미
        // 시계방향 -> y,x -> x,origin[0].length-1-y

        // 4번의 경우 x,y값의 자리가 변하고, y값의 반전을 의미
        // 반시계방향 -> y,x -> (origin.length-1-x),y


        // 5번의 경우 1->2로, 2->3으로, 3->4으로, 4->1로 이동됨을 의미
        // 위치값을 가지는 변수 필요.


        // 6번의 경우 2->1로 3->2로, 4->3 으로, 1->4으로 이동됨을 의미
        //


    }
}
