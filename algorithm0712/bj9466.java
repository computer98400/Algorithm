import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj9466 {
    static int[] numbers;

    static boolean[] visited;
    static boolean[] isAlreadyTeam;
    static int solution;
    public static void dfs(int target){

        if(visited[target]){
            isAlreadyTeam[target] = true;
            solution++;
        }else{
            visited[target] = true;
        }


        if(!isAlreadyTeam[numbers[target]]){
            dfs(numbers[target]);
        }
        visited[target] = false;
        isAlreadyTeam[target] = true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int qq=0; qq< TC;qq++){
            int N = Integer.parseInt(br.readLine());
            solution= 0;
            numbers = new int[N];
            visited = new boolean[N];
            isAlreadyTeam = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i< N;i++){
                numbers[i] =Integer.parseInt(st.nextToken())-1;
            }
            for(int i=0; i< visited.length;i++){
                if(!isAlreadyTeam[i]){
                    dfs(i);
                }
            }

            System.out.println(N-solution);
        }
    }
}
