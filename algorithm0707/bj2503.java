package algorithm0707;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj2503 {
    public static int[] origin;
    public static int[][] num;
    public static int solution = 0;

    public static void permu22(int count, int[] numbers, boolean[] selected) {
        
        if (count == 3) {
            int strike = 0;
            int ball = 0;
            boolean[] check = new boolean[3];
            boolean[] checked = new boolean[10];
            for (int i = 0; i < num.length; i++) {
                if (numbers[0] == num[i][0]) {
                    strike++;
                    check[0] = true;
                    checked[numbers[0]] = true;
                }
                if (numbers[1] == num[i][1]) {
                    strike++;
                    check[1] = true;
                    checked[numbers[1]] = true;
                }
                if (numbers[2] == num[i][2]) {
                    strike++;
                    check[2] = true;
                    checked[numbers[2]] = true;
                }

                if (strike != num[i][3]) {
                    return;
                }
                else {
                    for (int j = 0; j < 3; j++) {
                        if (!check[j] && !checked[numbers[j]]) {
                            if (numbers[j] == num[i][j]) {
                                ball++;
                            }
                        }
                    }
                    System.out.println("ball check : "+ball);
                    if (strike != num[i][4]) {
                        // System.out.println("check22");
                        return;
                    } else {
                        solution++;
                    }
                    ball = 0;
                    strike = 0;
                }
            }



            return;
        }
        for (int i = 0; i < 10; i++) {

            if (selected[i]) continue;

            numbers[count] = i;
            selected[i] = true;
            permu22(count + 1, numbers, selected);
            selected[i] = false;
        }
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        sc.nextLine();
        num = new int[tc][5];
       
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            String number = st.nextToken();

            for (int j = 0; j < 3; j++) {
                num[i][j] = number.charAt(j) - '0';
            }
            num[i][3] = Integer.parseInt(st.nextToken());
            num[i][4] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < tc; i++) {
            System.out.println(Arrays.toString(num[i]));
        }

        permu22(0, new int[3], new boolean[10]);
        System.out.println(solution);
    }

}