package Algorithm.algorithm1207;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj15686 {
    public static ArrayList<int[]> chickens;
    public static ArrayList<int[]> houses;
    public static int[][] map;
    public static int M;

	static void combi(int a, boolean[] visited, int N, int[] test,int[] solution) {
		if(a == N) {
			for (int i = 0; i < solution.length; i++) {
				System.out.print(solution[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < visited.length; i++) {
			if(visited[i] == true) continue;
			visited[i] = true;
			solution[a%N] = test[i];
			combi(a+1,visited,N,test,solution);
			visited[i] = false;
		}
		
	}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(sc.nextLine()," ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    houses.add(new int[]{i,j});
                }else if(map[i][j] == 2){
                    chickens.add(new int[]{i,j});
                } 
            }
        }
    }
}
