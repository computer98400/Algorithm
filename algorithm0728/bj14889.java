import java.util.*;
public class bj14889 {
    public static int N;
    public static int[][] map;
    public static int Min = Integer.MAX_VALUE;
    public static void combi(int idx,int count,boolean[] solution){
        if(count == N/2){
            cal(solution);
            return;
        }
        for(int i=idx;i<N; i++){
            if(solution[i]) continue;
            solution[i] = true;
            combi(i+1,count+1,solution);
            solution[i] = false;
        }
        
        
    }
    
    public static void cal(boolean[] solution){
        int start = 0;
        int link = 0;
        System.out.println(Arrays.toString(solution));
        for(int i=0; i< N-1; i++){
            for(int j= i+1; j<N; j++){
                if(solution[i] && solution[j]){
                    start+= map[i][j];
                    start+= map[j][i];
                }else if(!solution[i] && !solution[j]){
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        System.out.println(start+" "+link);
        int diff = Math.abs(start-link);
        
        if(diff == 0){
            System.out.println(diff);
            System.exit(0);
        }
        
        Min = Math.min(Min, diff);
    }
    
    
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];
        for(int i=0; i< 4; i++){
            String[] temp = sc.nextLine().split(" ");
            for(int j=0; j< 4; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        
        combi(0,0,new boolean[N]);

        System.out.println(Min);
    }
}
