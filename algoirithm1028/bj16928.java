import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class checkTest {
    static int[] map = new int[100];
    static boolean[] visited = new boolean[100];
    static class node{
        int position;
        int count;

        node(int position, int count){
            this.position = position;
            this.count = count;
        }
    }

    public static void bfs(){
        Queue<node> que = new LinkedList<>();
        que.offer(new node(0,0));
        visited[0] = true;

        while(!que.isEmpty()){
            node temp = que.poll();

            if(temp.position == 99){
                System.out.println(temp.count);
                return;
            }
            for(int i=1; i< 7; i++){
                int move = temp.position + i;

                if(move < map.length && !visited[move]){
                    if(map[move] != 0){
                        visited[move] = true;
                        que.offer(new node(map[move], temp.count+1));
                    }else{
                        visited[move] = true;
                        que.offer(new node(move, temp.count+1));
                    }
                }
            }


        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        int allinput = ladder+snake;

        for(int temp =0;temp<allinput; temp++){
            st = new StringTokenizer(br.readLine()," ");
            int portal = Integer.parseInt(st.nextToken())-1;
            int destination = Integer.parseInt(st.nextToken())-1;
            map[portal] = destination;
        }
        bfs();
    }
}
