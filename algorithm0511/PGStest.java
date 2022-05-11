package algorithm0511;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGStest {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            q.add((100-progresses[i])%speeds[i] == 0 ? (100-progresses[i])/speeds[i] : ((100-progresses[i])/speeds[i] + 1));
        }

        int start = q.poll();
        int cnt = 1;

        while(!q.isEmpty()){
            System.out.println(result.toString());
            int next = q.poll();
            
            if (start >= next) {
            
                cnt++;
            
            } else {

                result.add(cnt);
                start = next;
                cnt = 1;
            
            }
        }
        result.add(cnt);

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.poll();
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[] { 93, 30, 55 }, new int[] { 1,30,5 });
        solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1,1,1,1,1,1 });

    }
}
