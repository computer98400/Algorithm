import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj20056 {
    public static ArrayList<subfire>[][] map;
    public static ArrayList<fireball> fireballs;

    public static int[] dirY = {-1,-1,0,1,1,1,0,-1};
    public static int[] dirX = {0,1,1,1,0,-1,-1,-1};

    static class subfire{
        int m;
        int d;
        int s;

        subfire(){
            this.m = 0;
            this.d= 0;
            this.s= 0;
        }
        subfire(int m, int s, int d){
            this.m = m;
            this.s = s;
            this.d = d;
        }

    }
    static class fireball{
        int y;
        int x;
        int m;
        int s;
        int d;

        fireball(int y, int x, int m, int s, int d){
            this.y = y;
            this.x = x;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static int position(int input, int s){
        int output=0;
        int test = s;
        if(input+test <0 ) {
            output = (input+test) + map.length;
        }else if((input+test) >= map.length){
            output = (input+test) - map.length;
        }else{
            output = input+test;
        }
        return output;
    }


    public static void move(){
        //1. 모든 파이얼볼이 자신의 방향 d로 속력 s만큼 이동.
        for(fireball single : fireballs){
            int tempY = dirY[single.d] == 0 ? single.y :position(single.y,(dirY[single.d]*single.s%map.length));
            int tempX = dirX[single.d] == 0 ? single.x :position(single.x,(dirX[single.d]*single.s%map.length));
            map[tempY][tempX].add(new subfire(single.m,single.s, single.d));
        }
        fireballs = new ArrayList<>();

        for(int i=0; i< map.length;i++){
            for(int j=0; j< map.length;j++){
                if(map[i][j].size() == 1){
                    fireballs.add(new fireball(i,j,map[i][j].get(0).m,map[i][j].get(0).s,map[i][j].get(0).d));
                }else if(map[i][j].size() >= 2){
                    divide(i,j);
                }
            }
        }
        for(Iterator<fireball> temp = fireballs.iterator(); temp.hasNext();){
            fireball single = temp.next();
            if(single.m == 0){
                temp.remove();
            }
        }
    }


    public static void divide(int y, int x){
        int resultM = 0;
        int resultS = 0;
        int h = 0;
        int j = 0;
        int resultD = 0;
        int count =map[y][x].size();
        for(subfire single : map[y][x]){
            resultM += single.m;
            resultS += single.s;
            if(single.d%2 == 1){
                h++;
            }else{
                j++;
            }
        }
        resultD = h == count || j == count ? 1 : 0;

        int[] arrJ = {0,2,4,6};
        int[] arrH = {1,3,5,7};
        for(int i =0; i< 4; i++){
            fireballs.add(new fireball(y,x,resultM/5, resultS/count,(resultD == 1 ? arrJ[i] :arrH[i])));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        fireballs = new ArrayList<>();
        for(int i=0; i< M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireballs.add(new fireball(y,x,m,s,d));
        }

        while(K > 0){
            map = new ArrayList[N][N];

            for(int i =0; i< N; i++){
                for(int j=0; j< N; j++){
                    map[i][j] = new ArrayList<>();
                }
            }
            move();
            K--;
        }
        int solution = 0;
        for(fireball temp : fireballs){
            solution+= temp.m;
        }
        System.out.println(solution);

    }
}
