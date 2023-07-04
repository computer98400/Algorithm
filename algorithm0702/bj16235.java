import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;


public class bj16235 {
    public static cell[][] map;
    public static ArrayList<int[]> arrived = new ArrayList<>();
    public static ArrayList<int[]> breed = new ArrayList<>();
    public static int[][] feed;
    static class cell{
        int food;
        int deadidx;
        ArrayList<Integer> list;

        cell(int food){
            this.food = food;
            this.list = new ArrayList<>();
            this.deadidx = -1;
        }
    }

    public static void springsummer(){
        for(int y=0; y<map.length; y++){
            for(int x=0; x<map.length; x++){
                int foodadd =0;
                // 살아잇는 나무 인지 확인
                if(map[y][x].list.size() > 0){
//                    System.out.println("======== info  Y : "+y+" X : "+x+" tree size :"+map[y][x].list.toString()+" food : "+map[y][x].food);
                    int idx =0;
                    //해당되는 리스트값에서
                    for(Iterator<Integer> temp = map[y][x].list.iterator(); temp.hasNext();){
                        //순차적으로 탐색
                        int q = temp.next();
//                        System.out.println("current Tree : "+ q);
                        //만약 각 리스트의 나무나이가 음식보다 크다면
                        if(q > map[y][x].food){
                            //죽은나무로 취급하고 음식+= q/2 그리고 해당 값 리스트에서 remove()
                            foodadd += q/2;
                            temp.remove();
                        }else{
                            //아니라면 나이만큼 -해주기.
                            map[y][x].food -= q;
                            //만약 나무나이가 5의 배수라면
                            if((q+1)%5 == 0){
                                //breed에 추가해주기.
                                breed.add(new int[]{y,x});
                            }
                            map[y][x].list.set(idx,map[y][x].list.get(idx)+1);
                            idx++;
                        }
                    }
                    //리스트를 모두 순회하고 죽은 나무들을 추가해줌.
                    map[y][x].food += foodadd;
//                    System.out.println("remain food : "+map[y][x].food);
                }

            }
        }
//        System.out.println("Spring and Summer is gone"+"======================");
    }

    public static int[] dirY = new int[]{-1,-1,-1,0,0,1,1,1};
    public static int[] dirX = new int[]{-1,0,1,-1,1,-1,0,1};

    public static void auturm(){
        for(int[] single : breed){
            for(int i=0; i< dirY.length;i++){
                if(single[0]+dirY[i] > -1 && single[0]+dirY[i] < map.length &&single[1]+dirX[i] > -1 && single[1]+dirX[i] < map.length ){
                    map[single[0]+dirY[i]][single[1]+dirX[i]].list.add(0, 1);
                }
            }
//            System.out.println(single[0]+" "+single[1]+" "+map[single[0]][single[1]].list.toString());
        }
        breed  = new ArrayList<int[]>();
    }


    public static int winter(){
        int solution = 0;
        for(int i=0; i< map.length;i++){
            for(int j =0; j<map.length; j++){
                map[i][j].food += feed[i][j];
//                System.out.print(map[i][j].list.toString()+" ");
                solution += map[i][j].list.size();
            }
//            System.out.println();
        }
//        System.out.println(solution);
        return solution;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new cell[N][N];
        feed = new int[N][N];

        for(int temp=0; temp<N; temp++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int column=0;column<N;column++){
                map[temp][column]= new cell(5);
                feed[temp][column] = Integer.parseInt(st.nextToken());
            }
        }

        for(int temp=0; temp<M; temp++){
            st = new StringTokenizer(br.readLine(), " " );
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            map[x][y].list.add(z);
            arrived.add(new int[]{x,y});
        }
        int result = 0;
        while(K > 0){
            springsummer();
            auturm();
            result = winter();
//            System.out.println("arrived Tree : "+result);
            if(result <= 0){
                break;
            }
            K--;
        }

        System.out.println(result);


    }
}


