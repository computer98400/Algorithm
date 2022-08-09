package algorithm0707;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj10973 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int[] solution = new int[N];
        ArrayList<Integer> numbers = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        while(st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        
        int idx = -1;
        for (int i = numbers.size() - 1; i > 0; i--) {
            if (numbers.get(i-1) > numbers.get(i)) {
                idx = i - 1;
                break;
            }
        }

        int change = -1;
        if (idx != -1) {

            for (int i = idx + 1; i > -1; i--) {
                if (numbers.get(i) < numbers.get(idx)) {
                    change = i;
                }
            }
        }
        int temp1 = numbers.get(idx);
        int temp2 = numbers.get(change);

        numbers.remove(idx);
        numbers.remove(change);

        Collections.reverse(numbers);
        for (int i = 0; i < solution.length; i++) {
            if (solution[i] == 0) {
                solution[i] = numbers.get(i);
            }
        }
    }
}
