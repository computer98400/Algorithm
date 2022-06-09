package algorithm0608;

public class bj15596 {
    
    public static long sum(int[] a) {
        long answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i];
        }
        return answer;
    }

}