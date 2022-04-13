package algorithm0413;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class psfailurerate {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[][] failureRate = new int[N][2];
        
        for (int i = 1; i < N + 1; i++) {

            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    failureRate[i - 1][0]++;
                    failureRate[i - 1][1]++;
                } else if (stages[j] > i) {
                    failureRate[i - 1][1]++;
                }
            }
        }
        ArrayList<double[]> arr = new ArrayList<>();
        for (int i = 0; i < failureRate.length; i++) {
            if (failureRate[i][0] == 0 && failureRate[i][1] == 0) {
                arr.add(new double[] { i + 1, 0 });
            } else {
                arr.add(new double[] { i + 1, (double) failureRate[i][0] / (double) failureRate[i][1] });
            }
        }
        Collections.sort(arr, ((o1, o2) -> o1[1] == o2[1] ? (o1[0] <= o2[0] ? -1 : 1) : (o1[1] > o2[1] ? -1 : 1)));
        
        // for (int i = 0; i < arr.size(); i++) {
        //     System.out.println("check : "+arr.get(i)[0]);
        // }
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = (int) arr.get(i)[0];
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }


    public static void main(String[] args) {
        
        solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
        solution(4, new int[] {4,4,4,4,4});
    }
}
