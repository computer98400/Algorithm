package Algorithm.algorithm1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2206 {
    

    public static int[][] map;
    public static int[] dirX = {0,0,1,-1};
    public static int[] dirY = {1,-1,0,0};
    public static int[][] visited;
    public static int solution;
    // 기존에 좌표값과 맵을 통해서 표시하고 판단했다면
    // 해당 문제의 내용은 좌표값과 visited배열을 통해서 판단하게 된다.
    // 어떤 점이 다르냐 =해당문제의 경우 도착점까지 도달하기위해 계속해서 최소의 값을 사용하기때문이다.
    // 해당 좌표에 가장 작은 값이 자동으로 입력되기 때문이다.
    // 간단하게 말해서 기존에 map에 표기되었던 값을 클래스로 옮겨서 관리한다는 의미이다.



    //상태 관리용 클래스
    //노드의 상태는 x,y 그리고 벽을 부섰는지 아닌지만 확인.
    static class node{
        int x;
        int y;
        int distance;   //거리 지정
        int broke;      //벽을 부순 상태 저장.

        node(int y, int x, int distance,int broke){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.broke = broke;
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        solution = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j)-'0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        if(N != 1 && M != 1){
            bfs();
        }else{
            solution = 1;
        }

        if(solution == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(solution);
        }
    }

    static void bfs(){
        //상태관리를 포함한 node클래스를 통해 queue를 만든다.
        Queue<node> test = new LinkedList<>();
        // for (int i = 0; i < map.length; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        //시작위치 및 거리값 추가.
        test.offer(new node(0,0,1,0));
        visited[0][0] = 0;
        //visited에 벽에 대한 정보와 방문 정보를 같이 담게 되면 해결?

        while (!test.isEmpty()) {
            node temp = test.poll();
           // System.out.println(temp.y+" "+temp.x);
            for (int i = 0; i < dirX.length; i++) {
                int tempY = temp.y + dirY[i];
                int tempX = temp.x + dirX[i];
                if(tempY == map.length-1 && tempX == map[0].length-1){
                    solution = temp.distance+1;
                    return;
                }
                if(tempY>= 0 && tempY < map.length && tempX>= 0 && tempX < map[0].length && visited[tempY][tempX] > temp.broke){
                    //System.out.println("pos");
                    if(map[tempY][tempX] == 0){
                    //    System.out.println("Add pos : "+tempY+" "+tempX);
                        visited[tempY][tempX] = temp.broke;
                        test.offer(new node(tempY,tempX,temp.distance+1,temp.broke));
                    }else{
                        if(temp.broke == 0){
                            visited[tempY][tempX] = temp.broke+1;
                            test.offer(new node(tempY,tempX,temp.distance+1,temp.broke+1));
                        }
                    }
                }
            }
          
        }
    }
}
