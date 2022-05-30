package algorithm0530;

public class skillchecklv1_2 {
    public static String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        solution(new String[] {"Jane", "Kim"});

    }
}
