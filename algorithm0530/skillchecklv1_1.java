package algorithm0530;

public class skillchecklv1_1 {
    public static int solution(int n) {
        int answer = 0;
        String trans = Integer.toString(n);
        
        for (int i = 0; i < trans.length(); i++) {
            int temp = trans.charAt(i) - '0';
            answer += temp;
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        solution(123);
    }
}
