package permuNcombi;

import java.util.Arrays;

public class combi_mustStudy {
    
    public static int[] origin;
    
    public static void combi(int count, int[] numbers, int N, int idx) {
        if (count == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = idx; i < numbers.length; i++) {
            numbers[count] = origin[i];
            combi(count + 1, numbers, N, i + 1);
        }
    }
    public static void combi2(int count, int[] numbers, int N, int idx) {
        if (count == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = idx; i < numbers.length; i++) {
            numbers[count] = origin[i];
            combi2(count + 1, numbers, N, idx + 1);
        }
    }
    


    public static void main(String[] args) {

        origin = new int[] {1231, 1232, 1233, 1234};
        Arrays.sort(origin);

        combi(0, new int[4], 4, 0);
        combi2(0, new int[4], 4, 0);

    }
}
