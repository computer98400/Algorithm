import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj17135 {
    public static int[][] map;
    public static int[][] origin;
    public static int N;
    public static int M;
    public static int D;
    //N과 같아지면 사라짐.
    //궁수가 잡았을 때 맵에 직접적으로 0으로 표시되므로 상관이없다.
    //한줄씩 내려오는거만 표현
    public static int[][] move(){
        int[][] tempMap = new int[N+1][M];

        for(int i=0; i< N; i++){
            tempMap[i+1]=map[i];
        }
        for(int i=0; i< M;i++){
            tempMap[N][i] = 0;
        }
        return Arrays.copyOf(tempMap, tempMap.length-1);
    }


    //각 값들을 list에다가 넣기.
    //값을 정렬. -> 궁수의 위치에 따라서 정렬이 다시 된다.
    public static ArrayList<int[]> scan(){
        ArrayList<int[]> output = new ArrayList<>();

        for(int i=0; i< map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] == 1){
                    output.add(new int[]{i,j});
                }
            }
        }
        return output;
    }


    // 리스트를 정렬한다.
    // 리스트의 첫번째 적을 없애고
    //    map 상에서 1의 값을 0으로 변경  -> catchCount++;
    // return으로 list를 다시 내보낸다.
    public static int sortEnemy(ArrayList<int[]> input, int[] archer1, int[] archer2, int[] archer3){
        int catchCount=0;
        ArrayList<int[]> outputTest = new ArrayList<>();
        //처음 아처가 우선권을 가진다.
        //두번째 아처는 첫번째 아처가 없앤 나머지 list중에서 적을 죽인다.
        //세번째 아처는 두번째 아처가 없앤 나머지 list중에서 적을 죽인다.
        Collections.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(Math.abs(o1[0]-archer1[0])+Math.abs(o1[1]-archer1[1]) < Math.abs(o2[0]-archer1[0])+Math.abs(o2[1]-archer1[1]) ){
                    return -1;
                }else if(Math.abs(o1[0]-archer1[0])+Math.abs(o1[1]-archer1[1]) == Math.abs(o2[0]-archer1[0])+Math.abs(o2[1]-archer1[1])){
                    return o1[1] - o2[1];
                }else{
                    return 1;
                }
            }
        });
        if(input.size() != 0 && Math.abs(input.get(0)[0]-archer1[0])+Math.abs(input.get(0)[1]-archer1[1]) <= D){
            outputTest.add(input.get(0));
        }
//        System.out.println("archer 1 : "+ Arrays.toString(archer1));
//        for(int[] temp : input){
//            System.out.print(Arrays.toString(temp));
//        }
//        System.out.println();
//        for(int[] temp : map){
//            System.out.println(Arrays.toString(temp));
//        }
//        System.out.println("========================");


        Collections.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(Math.abs(o1[0]-archer2[0])+Math.abs(o1[1]-archer2[1]) < Math.abs(o2[0]-archer2[0])+Math.abs(o2[1]-archer2[1]) ){
                    return -1;
                }else if(Math.abs(o1[0]-archer2[0])+Math.abs(o1[1]-archer2[1]) == Math.abs(o2[0]-archer2[0])+Math.abs(o2[1]-archer2[1])){
                    return o1[1] - o2[1];
                }else{
                    return 1;
                }
            }
        });
        if(input.size() != 0 && Math.abs(input.get(0)[0]-archer2[0])+Math.abs(input.get(0)[1]-archer2[1]) <= D){
            outputTest.add(input.get(0));
        }

//        System.out.println("archer 2 : "+ Arrays.toString(archer2));
//        for(int[] temp : input){
//            System.out.print(Arrays.toString(temp));
//        }
//        System.out.println();
//        for(int[] temp : map){
//            System.out.println(Arrays.toString(temp));
//        }
//        System.out.println("========================");

        Collections.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(Math.abs(o1[0]-archer3[0])+Math.abs(o1[1]-archer3[1]) < Math.abs(o2[0]-archer3[0])+Math.abs(o2[1]-archer3[1]) ){
                    return -1;
                }else if(Math.abs(o1[0]-archer3[0])+Math.abs(o1[1]-archer3[1]) == Math.abs(o2[0]-archer3[0])+Math.abs(o2[1]-archer3[1])){
                    return o1[1] - o2[1];
                }else{
                    return 1;

                }
            }
        });
        if(input.size() != 0 && Math.abs(input.get(0)[0]-archer3[0])+Math.abs(input.get(0)[1]-archer3[1]) <= D){
            outputTest.add(input.get(0));
        }
//        System.out.println("archer 3 : "+Arrays.toString(archer3));
//        for(int[] temp : input){
//            System.out.print(Arrays.toString(temp));
//        }
//        System.out.println();
//        for(int[] temp : map){
//            System.out.println(Arrays.toString(temp));
//        }
//        System.out.println("========================");

        for(int i=0; i< outputTest.size(); i++){
//            System.out.print(Arrays.toString(outputTest.get(i))+" ");
            if(map[outputTest.get(i)[0]][outputTest.get(i)[1]] == 1){
                map[outputTest.get(i)[0]][outputTest.get(i)[1]] = 0;
                catchCount++;
            }
        }
//        System.out.println();
        return catchCount;
    }
    public static int solution = 0;
    //궁수 배치
    public static void combi(int idx,int n, int[] output){
        if(idx == 3){
            for(int i=0; i< N; i++){
                for(int j=0; j< M; j++){
                    map[i][j] = origin[i][j];
                }
            }
//            System.out.println("testcase******************************");
            int caseCount = calculate(output[0], output[1], output[2]);
            solution  = Math.max(solution,caseCount);
//            System.out.println("testcase******************************");
//            System.out.println(caseCount);
            return;
        }

        for(int i=n; i<M; i++){
            output[idx] = i;
            combi(idx+1,i+1, output);
        }
    }
    public static int calculate(int archer1, int archer2, int archer3){
        int catchCount = 0;
        while(scan().size() != 0){
            catchCount += sortEnemy(scan(),new int[]{N,archer1},new int[]{N,archer2},new int[]{N,archer3});
            map = move();
        }
        return catchCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        origin = new int[N][M];
        for(int i=0; i< N; i++){
            st  = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;
                origin[i][j] = number;
            }
        }

        combi(0,0,new int[3]);
        System.out.println(solution);
    }
}
