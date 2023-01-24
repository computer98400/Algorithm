package algorithm0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj17140 {
    public static int[][] origin;

    static class node implements Comparable<node>{
        int number;
        int count;

        public node(int number,int count){
            this.number = number;
            this.count = count;
        }
        @Override
        public int compareTo(node o) {
            if( this.count > o.count){
                return 1;
            }else if(this.count == o.count){
                if(this.number < o.number){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                return -1;
            }
        }
        @Override
        public String toString() {
            return number+" "+count;
        }
    }

    public static void sort(int[] rows){
        int[] counter = new int[100];
        for(int i=0; i< rows.length; i++){
            counter[rows[i]]++;
        }

        ArrayList<node> test = new ArrayList<>();


        for(int i=1; i< counter.length; i++){
            if( counter[i] != 0){
                test.add(new node(i,counter[i]));
            }
        }

        
        test.sort(null);
        // System.out.println(test.toString());
        int[] newarr = new int[test.size()*2];

        for(int i=0; i< test.size(); i++){
            newarr[i*2] = test.get(i).number;
            newarr[i*2+1] = test.get(i).count;
        }

        System.out.println(Arrays.toString(newarr));

        if(newarr.length > 100){
            //100짜리로 잘라서 리턴
        }else{
            //그냥 리턴
        }
    }


    public static void Rsort(int[][] map){
        System.out.println(map.length);

        int[] test = new int[map.length];

        for (int[] temp : map) {
            for(int i=0; i< temp.length; i++){
                
            }
        }
    }
    //각 줄(행, 열)에 해당하는 1차원 배열 뽑아내기
    public static int[] extract(char dir, int idx) {
        ArrayList<Integer> test = new ArrayList<>();
        if (dir == 'r') {
            for (int i = 0; i < origin.length; i++) {
                test.add(origin[idx][i]);
            }
        } else {
            for (int i = 0; i < origin[0].length; i++) {
                test.add(origin[i][idx]);
            }
        }


        /// 각 숫자 세는 거.


        
        int[] trans = new int[test.size()];
        for (int i = 0; i < test.size(); i++) {
            trans[i] = test.get(i);
        }
        return trans;
    }









    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //인덱스 값이 존재해야함 == 각 배열? 행중에 가장 긴 길이, 열 중에 가장 긴 길이 저장. 
        //-> 열 길이가 100 초과 = 100으로 변경

        origin = new int[3][3];

        int rowsLen = origin.length;
        int columnsLen = origin[0].length;

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<3; j++){
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while(count <100){
            if (rowsLen >= columnsLen) {
                for (int i = 0; i < origin.length; i++) {
                    int[] temp1 = extract('r', i);

                    

                }
            } else {
                for (int i = 0; i < origin[0].length; i++) {
                    extract('c', i);
                    int[] temp2 = extract('r', i);
                }
                
            }


            count++;
        }
        System.out.println("0,0,1,2,3,3,3,4");
        sort(new int[]{0,0,1,2,3,3,3,4});
    }
}
