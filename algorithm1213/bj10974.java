package algorithm1213;
import java.util.Scanner;

public class bj10974 {

    static void perm(int cnt,int N, int[] numbers, boolean[] isSelected) {
		if(cnt == N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i] + " ");
			}
			System.out.println(sb.toString());
	//	System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i < isSelected.length; i++) {
			if (isSelected[i] == true)	continue;
			numbers[cnt] = i;
			isSelected[i] =true;
			perm(cnt+1, N, numbers, isSelected);
			isSelected[i] =false;
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
	 	int[] numbers = new int[N+1];
	 	boolean[] isSelected = new boolean[numbers.length];
		
		
		perm(0,N,numbers,isSelected);
	
    }
}
