import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//플로이드 와샬
public class bj11403{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // i= 각 정점   j,k 경로
        for(int i=0; i< N; i++){
            for(int j=0; j< N; j++){
                for(int k=0; k< N; k++){
                    if(map[j][i] == 1 && map[i][k] == 1){
                        map[j][k] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] raw : map){
            for(int i=0; i< raw.length; i++){
                sb.append(raw[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
