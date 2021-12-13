package permuNcombi;

import java.util.Arrays;
import java.util.Scanner;

public class permu {
	
	public static void permu2(int count, int N,int[] origin, int[] numbers, boolean[] selected) {
        if (count == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 1; i < selected.length; i++) {
            if (selected[i]== true) continue;
            
            numbers[count] = origin[i];
            selected[i] = true;
            permu2(count + 1, N,origin, numbers, selected);
            selected[i] = false;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N+1];
        boolean[] isSelected = new boolean[numbers.length];
        int[] origin = new int[N + 1];
        for (int i = 0; i < origin.length; i++) {
            origin[i] = (int) (Math.random() * 100);
        }
        permu2(0, N,origin, numbers, isSelected);

    }
	

}


