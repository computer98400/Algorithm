package algorithm0810;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj14889 {
    public static int[][] map;
    public static boolean[] checking;

    //스타트와 링크 구분하기 위해 조합사용
    public static void combi(int N, int idx, int count, int[] numbers) {
        if (N / 2 == count) {
            //20짜리 배열
            checking = new boolean[N];

            //스타트팀을 구분하는 배열(numbers)     numbers = 10짜리 배열 (0~19까지의 조합을 집어넣음.  0 10 11 14 15 .. 19)
            System.out.println(Arrays.toString(numbers));
            // for (int i = 0; i < numbers.length; i++) {
            //     checking[numbers[i]] = true;
            // }

            // ArrayList<Integer> checked = new ArrayList<>();
            // ArrayList<Integer> unchecked = new ArrayList<>();

            // for (int i = 0; i < N; i++) {
            //     if (checking[i])
            //         checked.add(i);
            //     else
            //         unchecked.add(i);
            // }

            // test(checked, unchecked);

            return;
        }

        for (int i = idx; i < N; i++) {
            numbers[count] = i;
            combi(N, i + 1, count + 1, numbers);
        }

    }
    
    //체크된 값과 체크되지 않은 값확인. (스타트팀,  링크팀을 나눈 리스트를 가지고 계산)
    public static void test(ArrayList<Integer> checked, ArrayList<Integer> unchecked) {
        int start = 0;
        int link = 0;
        for (int i = 0; i < checked.size(); i++) {
            for (int j = 0; j < checked.size(); j++) {
                if (i == j)
                    continue;
                    start+=map[checked.get(i)][checked.get(j)];
                    link+=map[unchecked.get(i)][unchecked.get(j)];
                }
        }
        solution = Math.min(solution, Math.abs(start - link));
    }
    
    public static int solution = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];

        sc.nextLine();
        StringTokenizer st;
        // for (int i = 0; i < N; i++) {
        //     st = new StringTokenizer(sc.nextLine(), " ");
        //     for (int j = 0; j < N; j++) {
        //         map[i][j] = Integer.parseInt(st.nextToken());
        //     }
        // }
        




        long before = System.currentTimeMillis();
        
        combi(N,0, 0, new int[N / 2]);

        long after = System.currentTimeMillis();
        System.out.println(after - before);
        System.out.println(solution);
    }
}
