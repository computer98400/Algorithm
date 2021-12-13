package algorithm1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10816 {
    //public static ArrayList<Integer> numbers;
    public static int[] numbers;
    //public static ArrayList<Integer> numbers2;
    
    //해당 수가 존재하는지 확인. == 이분탐색 메소드
    public static int binary(int searchN) {
        int left = 0;
        int right = numbers.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == searchN) {
                return numbers[mid];
            }
            if (mid > searchN)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return 0;
    }

    //완탐 
    //6 3 2 10 10 10 -10 -10 7 3
    //logN
    //10 9 -5 2 3 4 5 -10
    //해시맵
    //map - key/
    //입력받을때부터 key value 값으로 갯수를 확인할 수 있다.
    // key = ??;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numbers = new int[20000000];
        
         int N = Integer.parseInt(br.readLine());
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //기본 배열 만들기
        for (int i = 0; i < N; i++) {
            numbers[10000000 + Integer.parseInt(st.nextToken())]++;
        }
        // 8
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

         StringBuilder sb = new StringBuilder();
        //방안 1  처음에 리스트가 2개를 생성.
        //각각의 값 찾기

        // for (int i = 0; i < numbers.length; i++) {
        //     if (numbers[i] != 0) {
        //         System.out.println(i+" "+numbers[i]);
        //     }
        // }
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            //System.out.println(10000000+temp);
            int count = binary(10000000+temp);
        //    System.out.println("test       "+count);
            sb.append(count+ " ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }
}


// }
// 6 3 2 10 10 10 -10 -10 7 3   -> 6 3 2 10 -10 7
// 각 숫자의 갯수를 채크해야됨.
//해쉬맵은 모름.. key = 10, value = 3
// 10 9 -5 2 3 4 5 -10