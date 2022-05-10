package algorithm0509;

import java.util.Arrays;

public class psbaduser {
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        //각각 문자열을 정렬한다면?
        for (int i = 0; i < user_id.length; i++) {
            char[] test = user_id[i].toCharArray();
            Arrays.sort(test);
            String temp = new String(test);
            System.out.println(temp);
        }
        //원본 문자열에서
        for (int i = 0; i < banned_id.length; i++) {
            char[] test = banned_id[i].toCharArray();
            Arrays.sort(test);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < test.length; j++) {
                if (test[j] != '*') {
                    sb.append(test[j]);
                }
            }
            System.out.println(sb.toString());
        }
        return answer;
    }
    public static void main(String[] args) {
        
        solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" }, new String[] {"fr*d*", "abc1**"});
    }
}
