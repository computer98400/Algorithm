package algorithm1222;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;


class node {
    int time;
    int location;
    //Stack<Integer> test = new Stack<>();

    node(int location, int time) {
        this.time = time;
        this.location = location;
        //this.test.push(location);
    }
}

public class bj13549 {

    public static int[] visited;

    public static void bfs(int N , int K) {
        PriorityQueue<node> temp = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
        //처음 입력 
        temp.offer(new node(N, 0));
        //해당 방문 표시
        visited[N] = 0;
        
        while (!temp.isEmpty()) {
            node pos = temp.poll();

            if (pos.location == K) {
              //  sb.append(pos.time);
             //   while(!pos.test.isEmpty()){
             //       sb.append(pos.test.pop());
             //   }
                return;
            }
            
            for (int i = 0; i < 3; i++) {
                int tempX = 0;
                if (i == 0)
                    tempX = pos.location * 2;
                if (i == 1)
                tempX = pos.location - 1;
                if (i == 2)
                tempX = pos.location + 1; 
                    

                if (tempX > 100000 || tempX < 0) {
                    //여기있는값. 100001
                    continue;

                } else {
                    //10
                    if (i == 0) {
                        //같거나 큰 이유 = 초기값 0으로 시작할시에
                        //초기값이 범위 외의 상황이라면, visited[10] =  0
                        if (visited[tempX] > pos.time) {
                            visited[tempX] = pos.time;
                            temp.offer(new node(tempX, pos.time));
                        }

                    } else {
                        //4 = 1 6 = 1
                        if (visited[tempX] > pos.time + 1) {
                            visited[tempX] = pos.time + 1;
                            temp.offer(new node(tempX, pos.time+1));
                        }
                    }

                    // if (i == 0 && visited[tempX]) {
                    //     visited[tempX] = pos.time;
                    //     temp.offer(new node(tempX, pos.time));
                    
                    // } else {
                        
                    //         visited[tempX] = true;
                    //         temp.offer(new node(tempX, pos.time + 1));
                    // }
                }
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        visited = new int[100001];
        Arrays.fill(visited, 100001);
        bfs(N, K);
        
        System.out.println(visited[K]);
    }
}
