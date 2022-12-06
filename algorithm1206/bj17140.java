import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj17140 {
    public static int[][] map = new int[100][100];
    public static int Ysize= 3;
    public static int Xsize =3;

    public static void scan(){
        int rowCheck = 0;
        int columnCheck = 0;
        for(int i=0; i< map.length; i++){
            for(int j=0; j< map.length; j++){
                if(map[i][0]== 0){
                    break;
                }
                if(map[i][j] == 0){
                    rowCheck = Math.max(rowCheck,j);
                    break;
                }
            }
            for(int j=0; j< map.length; j++){
                if(map[0][i]== 0){
                    break;
                }
                if(map[j][i] == 0){
                    columnCheck = Math.max(columnCheck,j);
                    break;
                }
            }
        }
        Ysize = columnCheck;
        Xsize = rowCheck;
    }


    public static void sortRow(char rc,int idx, int[] single){
        int[] tempMap = new int[101];
        int[] tempMap2 = new int[100];
        ArrayList<int[]> que = new ArrayList<>();
        for(int temp : single){
            tempMap[temp]++;
        }
        for(int i=0; i< tempMap.length; i++){
            if(tempMap[i] != 0 && i != 0){
                que.add(new int[]{i, tempMap[i]});
            }
        }

        Collections.sort(que, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]){
                    return -1;
                }else if(o1[1] == o2[1]){
                    if(o1[0] < o2[0]){
                        return -1;
                    }
                }
                return 0;
            }
        });
        for(int i=0;i<50; i++){
            if(que.size() <= i){
                break;
            }
            tempMap2[i*2] = que.get(i)[0];
            tempMap2[i*2+1] = que.get(i)[1];
        }



        if(rc == 'R'){
            for(int i=0; i<map.length;  i++){
                map[idx][i] = tempMap2[i];
            }
        }else if(rc == 'C'){
            for(int i=0; i<map.length;  i++){
                map[i][idx] = tempMap2[i];
            }
        }
    }

    public static void calculation(){
        scan();

        if(Ysize >= Xsize){
            for(int i=0; i<map.length; i++){
                sortRow('R',i,map[i]);
            }
        }else{
            for(int i=0;i < map.length; i++){
                int[] temp = new int[100];
                for(int j=0; j< map.length; j++){
                    temp[j] = map[j][i];
                }
                sortRow('C',i, temp);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int solutionR = Integer.parseInt(st.nextToken())-1;
        int solutionC = Integer.parseInt(st.nextToken())-1;
        int solution = Integer.parseInt(st.nextToken());

        for(int i =0; i <3; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j< 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count =0;

        while(true){
            if(count > 100){
                System.out.println(-1);
                break;
            }

            if(map[solutionR][solutionC] == solution){
                System.out.println(count);
                break;
            }
//            for(int[] temp : map){
//                System.out.println(Arrays.toString(temp));
//            }
            calculation();
            count++;
        }


    }
}
