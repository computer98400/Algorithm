package algorithm1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11582_notSolve {
    public static int[] numbers;
    
    //sort를 사용할시에 각 크기를 확인하면서 sort

    public static void divide(int x, int size, int process) {
        if (process == 0) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        
        if (size == 2) {
            int temp = Math.max(numbers[x], numbers[x + 1]);
            if (numbers[x] == temp) {
                numbers[x] = numbers[x + 1];
                numbers[x + 1] = temp;
                return;
            }
            return;
        }
        int divideSize = size / 2;
        
        divide(x, divideSize, process - 1);
        divide(x + divideSize, divideSize, process - 1);
    }
    
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int pro = Integer.parseInt(br.readLine());
        divide(0,N,pro);

    }
}
