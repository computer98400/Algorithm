package algorithm1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15663 {
    public static int[] origin;
    public static ArrayList<int[]> temp;
    //순열로 풀고, 방문 처리. (permu, visited)

    //현재 보고 있는 값과 이전값을 비교해야됨. visited[]에서 확인해야됨.

    // 순열일 시에, 데이터 다 저장하고, 비교해.
    public static void permu(int N, int M, int[] numbers, boolean[] visited, StringBuilder sb) {
        if (N == M) {
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i] + " ");
            }
            sb.append("\n");
            return;
        }
        // 1       7      9   9 
        // false false true false;
        // test = 9
        // origin[3] = 9  // test == origin 
        // false false true true;
        //0의 경우는 여백
        //static의 경우 0이 남아있음.

        //이전 값이 저장되있음.
        // 1 7 9 9
        // test = 1
        // true false false false

        // test = 7
        // flase true false false


        // test = 9-1
        // false false true false

        // test = 9-2

        int test = -1;
        for (int i = 0; i < visited.length; i++) {
            if (test == origin[i] || visited[i] == true) {
                continue;
            }
            test = origin[i];
            numbers[N] = origin[i];
            visited[i] = true;
            permu(N + 1, M, numbers, visited ,sb);
            visited[i] = false; 
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));       
        
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        temp = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        origin = new int[N];
        st= new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(origin);
        // System.out.println(Arrays.toString(origin));
        permu(0, M, new int[N], new boolean[N],sb);
        System.out.println(sb);
    }
}