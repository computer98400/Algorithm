import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj2170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map = new int[N][2];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, ((o1, o2) -> {
           if(o1[0] == o2[0]){
               return Integer.compare(o1[1], o2[1]);
           }else {
               return Integer.compare(o1[0],o2[0]);
           }

        }));

        int start = Integer.MIN_VALUE;
        int end =Integer.MIN_VALUE;
        int current = 0;
        int result = 0;
        for(int[] temp : map){
            if(temp[0] <= end && temp[1] > end){
                end = temp[1];
            }else if(temp[0] > end){
                result += (end-start);
                start = temp[0];
                end = temp[1];
            }
        }
        result += end-start;
        System.out.println(result);
    }
}
